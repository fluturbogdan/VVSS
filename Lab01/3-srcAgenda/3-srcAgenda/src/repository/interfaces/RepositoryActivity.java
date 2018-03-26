package repository.interfaces;

import java.util.Date;
import java.util.List;

import model.base.Activity;

public interface RepositoryActivity {

	List<Activity> getActivities();
	boolean addActivity(Activity activity);
	boolean removeActivity(Activity activity);
	boolean saveActivities();
	int count();
	List<Activity> activitiesByName(String name);
	List<Activity> activitiesOnDate(String name, Date d);
	
}
