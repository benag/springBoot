package todoapp.models;

/**
 * Created by ben on 24/03/17.
 */
public interface Worker {

     long getId();

     void setId(long id);

     String getFirstName();

     String getLastName();

     String getPosition();

     void setFirstName(String name);

     void setLastName(String name);

     void setPosition(String pos);

     void addTask (Task t);
}