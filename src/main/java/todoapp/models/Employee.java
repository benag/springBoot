package todoapp.models;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

/**
 * Created by ben on 24/03/17.
 */
@Document(collection="employees")
public class Employee implements Worker{

    @Id
    private String id;

    private Manager boss;

    private String firstName;

    private String position;

    private List<Task>  tasks = new ArrayList<>();

    private String lastName;

    private Date createdAt = new Date();

    public Employee(){}

    public Employee(String f, String l, String p){
        this.firstName = f;
        this.lastName = l;
        this.position = p;
    }

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

    public Manager getBoss() { return this.boss;}

    public void setBoss (Manager emp){ this.boss = emp;}

    public void setTasks (ArrayList<Task> t){ this.tasks = t;}

    public List<Task> getTasks() { return this.tasks;}

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, firstName='%s', position='%s']",
                getId(), getFirstName(), getPosition());
    }
}
