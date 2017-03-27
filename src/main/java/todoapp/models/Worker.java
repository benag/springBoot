package todoapp.models;

/**
 * Created by ben on 24/03/17.
 */
public interface Worker {

     String getId();

     void setId(String id);

     String getFirstName();

     String getLastName();

     String getPosition();

     void setFirstName(String name);

     void setLastName(String name);

     void setPosition(String pos);

     void addTask (Task t);
}