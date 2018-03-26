package controller;

import model.base.User;
import repository.interfaces.RepositoryUser;

/**
 * Created by Bogdan on 20.03.2017.
 */
public class UserController {
    private RepositoryUser rep;

    public UserController(RepositoryUser rep) {
        this.rep = rep;
    }


    public User getByUsername(String u) {
        return rep.getByUsername(u);
    }
}
