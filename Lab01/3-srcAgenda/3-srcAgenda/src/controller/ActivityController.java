package controller;

import model.base.Activity;
import repository.interfaces.RepositoryActivity;

import java.util.Date;
import java.util.List;

/**
 * Created by Bogdan on 20.03.2017.
 */
public class ActivityController {
    private RepositoryActivity rep;

    public ActivityController(RepositoryActivity rep) {
        this.rep = rep;
    }

    public void addActivity(Activity act) {
        rep.addActivity(act);
    }

    public List<Activity> activitiesOnDate(String name, Date d) {
        return rep.activitiesOnDate(name, d);
    }
}
