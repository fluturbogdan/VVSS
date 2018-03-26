package controller;

import model.base.Contact;
import repository.interfaces.RepositoryContact;

/**
 * Created by Bogdan on 20.03.2017.
 */
public class ContacteController {
    private RepositoryContact rep;

    public ContacteController(RepositoryContact rep) {
        this.rep = rep;
    }

    public void addContact(Contact c) {
        rep.addContact(c);
    }
}
