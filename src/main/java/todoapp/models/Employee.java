package todoapp.models;
import todoapp.classes.Worker;
import todoapp.classes.Task;
import todoapp.classes.Worker;
import java.util.Date;
import java.util.ArrayList;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ben on 24/03/17.
 */
@Document(collection="employees")
public class Employee implements Worker {

    @Id
    private String id;

//    @NotBlank
//    @Size(max=250)
//    @Indexed(unique=true)
    private String firstName;

    private String position;

    private ArrayList<Task>  tasks = new ArrayList<Task>();

    private ArrayList<Worker> employees = new ArrayList<Worker>();

    private String lastName;

    private Date createdAt = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getPosition() { return position; }

    public void setFirstName(String name) { this.firstName = name;}

    public void setLastName(String name) { this.lastName = name;}

    public void setPosition(String pos) { this.position = pos;}

    public void addTask (Task t) {this.tasks.add(t);}

    public void addEmployee(Worker emp) { this.employees.add(emp);}



}
