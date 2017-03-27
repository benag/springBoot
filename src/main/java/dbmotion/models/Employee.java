package dbmotion.models;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ben on 24/03/17.
 */
@Entity
@Table(name = "employee")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="employee")
public class Employee implements Worker{

    @Id
    @Column(name = "employeeId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @ManyToOne(targetEntity = Manager.class)
    @JsonBackReference
    protected Manager boss;

    protected String firstName;

    protected String position;

    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL)
    protected List<Task> tasks = new ArrayList<>();

//    @OneToMany(targetEntity = Report.class, cascade = CascadeType.ALL)
//    protected List<Report> reports = new ArrayList<>();

    protected String lastName;

    protected Date createdAt = new Date();

    @Column(insertable = false, updatable = false)
    protected String type;


    public Employee(){
    }

    public Employee(Employee e){
        this.position = e.position;
        this.firstName = e.firstName;
        this.lastName = e.lastName;
        this.boss = e.boss;
//        this.reports.addAll(e.reports);
        this.tasks.addAll(e.tasks);
        this.createdAt = e.createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getPosition() { return position; }

    public void setFirstName(String name) { this.firstName = name;}

    public void setLastName(String name) { this.lastName = name;}

    public void setPosition(String pos) { this.position = pos;}

    public void addTask (Task t) {this.tasks.add(t);}

//    public void addReport (Report r) {this.reports.add(r);}

    public Manager getBoss() { return this.boss;}

    public void setBoss (Manager emp){ this.boss = emp;}

    public void setTasks (ArrayList<Task> t){ this.tasks = t;}

    public List<Task> getTasks() { return this.tasks;}

//    public void setReports (ArrayList<Report> r){ this.reports = r;}
//
//    public List<Report> getReports() { return this.reports;}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, firstName='%s', position='%s']",
                getId(), getFirstName(), getPosition());
    }
}
