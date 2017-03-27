package todoapp.models;


import java.util.ArrayList;
import java.util.Date;
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
public class Manager extends Employee {


    private List<Worker> employees = new ArrayList<Worker>();

    public void addEmployee(Worker emp) { this.employees.add(emp);}

    private List<Report>  reports = new ArrayList<Report>();

    public void setReports (ArrayList<Report> r){ this.reports = r;}

    public List<Report> getReports() { return this.reports;}

    public void addReport (Report r) {this.reports.add(r);}

    public Manager(){}

    public Manager(String f, String l, String p){
        super(f, l,p);
//        this.firstName = f;
//        this.lastName = l;
//        this.position = p;
    }

    @Override
    public String toString() {
        String employeesString = "";
        Integer length = (Integer)employees.size();
        String lengthS = new String(length.toString());
        for (Worker e : employees) {
            employeesString = employeesString + e.toString();
        }
        return String.format(
                "Todo[id=%s, firstName='%s', position='%s', lengthS='%s', employees='%s']",
                getId(), getFirstName(), getPosition(), lengthS, employeesString);
    }

}
