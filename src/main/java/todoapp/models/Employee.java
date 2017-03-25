package todoapp.models;
import todoapp.classes.Worker;
import todoapp.classes.Task;
import todoapp.classes.Report;
import todoapp.classes.Worker;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ben on 24/03/17.
 */
@Document(collection="employees")
public class Employee  {

    @Id
    private String id;

//    @NotBlank
//    @Size(max=250)
//    @Indexed(unique=true)

    private Employee boss;

    private String firstName;

    private String position;

    private ArrayList<Task>  tasks = new ArrayList<>();

    private ArrayList<Report>  reports = new ArrayList<Report>();

    private ArrayList<Employee> employees = new ArrayList<Employee>();

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

    public void addEmployee(Employee emp) { this.employees.add(emp);}

    public List<Employee> getEmployees() { return this.employees;}

    public void setEmployees(List<Employee> emp) { this.employees = (ArrayList)emp;}

    public Employee getBoss() { return this.boss;}

    public void setBoss (Employee emp){ this.boss = emp;}

    @Override
    public String toString() {
        String employeesString = "";
        Integer length = (Integer)employees.size();
        String lengthS = new String(length.toString());
        for (Employee e : employees) {
            employeesString = employeesString + e.toString();
        }
        return String.format(
                "Todo[id=%s, firstName='%s', position='%s', lengthS='%s', employees='%s']",
                id, firstName, position, lengthS, employeesString);
    }

}
