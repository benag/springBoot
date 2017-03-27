package todoapp.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 24/03/17.
 */
@Entity
@DiscriminatorValue("manager")
public class Manager extends Employee {

    @OneToMany(mappedBy = "boss")
    @JsonManagedReference
    private List<Employee> employees = new ArrayList<>();
    
    public Manager(){
    }

    public Manager(Employee e){
        super(e);
    }

    public void addEmployee(Employee emp) { this.employees.add(emp);}

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        String employeesString = "";
        Integer length = employees.size();
        String lengthS = new String(length.toString());
        for (Worker e : employees) {
            employeesString = employeesString + e.toString();
        }
        return String.format(
                "Todo[id=%s, firstName='%s', position='%s', lengthS='%s', employees='%s']",
                getId(), getFirstName(), getPosition(), lengthS, employeesString);
    }

}
