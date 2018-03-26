package startApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import controller.ActivityController;
import controller.ContacteController;
import controller.UserController;
import exceptions.InvalidFormatException;

import model.base.Activity;
import model.base.Contact;
import model.base.User;
import repository.classes.RepositoryActivityFile;
import repository.classes.RepositoryContactFile;
import repository.classes.RepositoryUserFile;
import repository.interfaces.RepositoryActivity;
import repository.interfaces.RepositoryContact;
import repository.interfaces.RepositoryUser;

//functionalitati
//i.	 adaugarea de contacte (nume, adresa, numar de telefon, adresa email);
//ii.	 programarea unor activitati (denumire, descriere, data, locul, ora inceput, durata, contacte).
//iii.	 generarea unui raport cu activitatile pe care le are utilizatorul (nume, user, parola) la o anumita data, ordonate dupa ora de inceput.

public class MainClass {

	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			RepositoryContact contactRep = new RepositoryContactFile();
			RepositoryUser userRep = new RepositoryUserFile();
			RepositoryActivity activityRep = new RepositoryActivityFile(
					contactRep);
			ActivityController ctrlA=new ActivityController(activityRep);
			ContacteController ctrlC=new ContacteController(contactRep);
			UserController ctrlU=new UserController(userRep);

			User user = null;
			in = new BufferedReader(new InputStreamReader(System.in));
			while (user == null) {
				System.out.printf("Enter username: ");
				String u = in.readLine();
				System.out.printf("Enter password: ");
				String p = in.readLine();

				user = ctrlU.getByUsername(u);
				if (user!=null &&!user.isPassword(p))
                    user = null;
                if(user == null)
                    System.out.println("Login fail, user/password incorrect");
			}

			int chosen = 0;
			while (chosen != 4) {
				printMenu();
				chosen = Integer.parseInt(in.readLine());
				try {
					switch (chosen) {
					case 1:
						adaugContact(ctrlC, in);
						break;
					case 2:
						adaugActivitate(ctrlA, ctrlC, in, user);
						break;
					case 3:
						afisActivitate(ctrlA, in, user);
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			// List<Activity> act =
			// activityRep.activitiesByName(user.getName());
			// for(Activity a : act)
			// System.out.println(a.toString());
			activityRep.saveActivities();
			contactRep.saveContracts("bin\\files\\contacts.txt");
			userRep.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Program over and out\n");
	}

	private static void afisActivitate(ActivityController activityCtrl,
			BufferedReader in, User user) {
		try {
			System.out.printf("Afisare Activitate: \n");
			System.out.printf("Data(format: mm/dd/yyyy): ");
			String dateS = in.readLine();
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(dateS.split("/")[2]),
					Integer.parseInt(dateS.split("/")[0]) - 1,
					Integer.parseInt(dateS.split("/")[1]));
			Date d = c.getTime();

			System.out.println("Activitatile din ziua " + d.toString() + ": ");

			List<Activity> act = activityCtrl
					.activitiesOnDate(user.getName(), d);
			for (Activity a : act) {
				System.out.printf("%s - %s: %s - %s with: ", a.getStart()
						.toString(), a.getDuration().toString(), a
						.getDescription(),a.getLocatie());
				for (Contact con : a.getContacts())
					System.out.printf("%s, ", con.getName());
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("Eroare de citire: %s\n" + e.getMessage());
		}
	}

	private static void adaugActivitate(ActivityController activityController,
			ContacteController contactCtrl, BufferedReader in, User user) {
		try {
			System.out.printf("Adauga Activitate: \n");
			System.out.printf("Descriere: ");
			String description = in.readLine();
            System.out.printf("Locatie: ");
            String locatie = in.readLine();
			System.out.printf("Start Date(format: mm/dd/yyyy): ");
			String dateS = in.readLine();
			System.out.printf("Start Time(hh:mm): ");
			String timeS = in.readLine();
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(dateS.split("/")[2]),
					Integer.parseInt(dateS.split("/")[0]) - 1,
					Integer.parseInt(dateS.split("/")[1]),
					Integer.parseInt(timeS.split(":")[0]),
					Integer.parseInt(timeS.split(":")[1]));
			Date start = c.getTime();

			System.out.printf("End Date(format: mm/dd/yyyy): ");
			String dateE = in.readLine();
			System.out.printf("End Time(hh:mm): ");
			String timeE = in.readLine();
			
			c.set(Integer.parseInt(dateE.split("/")[2]),
					Integer.parseInt(dateE.split("/")[0]) - 1,
					Integer.parseInt(dateE.split("/")[1]),
					Integer.parseInt(timeE.split(":")[0]),
					Integer.parseInt(timeE.split(":")[1]));
			Date end = c.getTime();

			Activity act = new Activity(user.getName(), start, end,
					new LinkedList<Contact>(), description,locatie);

			activityController.addActivity(act);

			System.out.printf("S-a adugat cu succes\n");
		} catch (IOException e) {
			System.out.printf("Eroare de citire: %s\n" + e.getMessage());
		}

	}

	private static void adaugContact(ContacteController contactCtrl,
			BufferedReader in) {

		try {
			System.out.printf("Adauga Contact: \n");
			System.out.printf("Nume: ");
			String name = in.readLine();
			System.out.printf("Adresa: ");
			String adress = in.readLine();
			System.out.printf("Numar de telefon: ");
			String telefon = in.readLine();
            System.out.printf("Email: ");
            String email = in.readLine();
			
			Contact c = new Contact(name, adress, telefon,email);

			contactCtrl.addContact(c);

			System.out.printf("S-a adugat cu succes\n");
		} catch (IOException e) {
			System.out.printf("Eroare de citire: %s\n" + e.getMessage());
		} catch (InvalidFormatException e) {
			if (e.getCause() != null)
				System.out.printf("Eroare: %s - %s\n" + e.getMessage(), e
						.getCause().getMessage());
			else
				System.out.printf("Eroare: %s\n" + e.getMessage());
		}

	}

	private static void printMenu() {
		System.out.printf("Please choose option:\n");
		System.out.printf("1. Adauga contact\n");
		System.out.printf("2. Adauga activitate\n");
		System.out.printf("3. Afisare activitati din data de...\n");
		System.out.printf("4. Exit\n");
		System.out.printf("Alege: ");
	}
}