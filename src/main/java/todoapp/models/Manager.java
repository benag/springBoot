package todoapp.models;
import todoapp.classes.Task;
import todoapp.classes.Worker;


import java.util.ArrayList;
import java.util.Date;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ben on 24/03/17.
 */
@Document(collection="employees")
public class Manager implements Worker {

    @Id
    private String id;

    @NotBlank
    @Size(max=250)
    @Indexed(unique=true)
    private String firstName;

    private String lastName;

    private ArrayList<Worker> employees = new ArrayList<Worker>();

    private String position;

    private Date createdAt = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public void setFirstName(String name) { this.firstName = name;}

    public void setLastName(String name) { this.lastName = name;}

    public void addTask (Task t) {}

    public void setPosition(String pos){}

    public String getPosition (){ return this.position;}

    public void addEmployee(Worker emp) { this.employees.add(emp);}

}
