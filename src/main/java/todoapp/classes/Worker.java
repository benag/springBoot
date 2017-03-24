package todoapp.classes;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ben on 24/03/17.
 */
public interface Worker {

     String id = "";

     String firstName = "";

     String lastName = "";

     String position = "";

     Date createdAt = null;

     ArrayList<Task> tasks = null;

     ArrayList<Worker> employees = null;

     String getId();

     void setId(String id);

     String getFirstName();

     String getLastName();

     String getPosition();

     void setFirstName(String name);

     void setLastName(String name);

     void setPosition(String pos);

     void addTask (Task t);

     void addEmployee(Worker worker);
}