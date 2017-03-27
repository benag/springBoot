package dbmotion.controllers;

/**
 * Created by ben on 24/03/17.
 */

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dbmotion.models.Employee;
import dbmotion.models.Manager;
import dbmotion.models.Task;
import dbmotion.models.Report;
import dbmotion.repositories.EmployeeDao;
import dbmotion.repositories.ManagerDao;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ManagerDao managerDao;

    @RequestMapping(method=RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeDao.findAll();
    }

    @RequestMapping(value="/createEmployee", method=RequestMethod.POST)
    public Employee createEmployee(@Valid @RequestBody Employee emp) {
        return employeeDao.save(emp);
    }

    @RequestMapping(value="/createManager", method=RequestMethod.POST)
    public Manager createManager(@Valid @RequestBody Manager emp) {
        return managerDao.save(emp);
    }


    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        Employee emp = employeeDao.findOne(Long.valueOf(id));
        if(emp == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Employee>(emp, HttpStatus.OK);
        }
    }

    @RequestMapping(value="/employee", method=RequestMethod.PUT)
    public ResponseEntity<Employee> addEmployee(@RequestBody Map<String, String> payload) throws java.io.IOException {
        String addToEmployeeId = payload.get("addToId");
        String addEmployeeId = payload.get("addId");
        System.out.println(addToEmployeeId);
        System.out.println(addEmployeeId);
        Manager manager = managerDao.findOne(Long.valueOf(addToEmployeeId));
        if(manager == null) {
            System.out.println("not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        System.out.println("found");

        Employee subordinate = employeeDao.findOne(Long.valueOf(addEmployeeId));
        subordinate.setBoss(manager);
        manager.addEmployee(subordinate);
        System.out.println(manager.toString());
        Employee updatedEmployee = employeeDao.save(subordinate);
        Manager updatedManger = managerDao.save(manager);
        System.out.println(updatedEmployee.toString());
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }
    @RequestMapping(value="/manager", method=RequestMethod.PUT)
    public ResponseEntity<Manager> addManager(@RequestBody Map<String, String> payload) throws java.io.IOException {
        String addToEmployeeId = payload.get("addToId");
        String addEmployeeId = payload.get("addId");
        System.out.println(addToEmployeeId);
        System.out.println(addEmployeeId);
        Manager manager = managerDao.findOne(Long.valueOf(addToEmployeeId));
        if(manager == null) {
            System.out.println("not found");
            return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
        }
        System.out.println("found");
        Manager subordinate = managerDao.findOne(Long.valueOf(addEmployeeId));
        subordinate.setBoss(manager);
        manager.addEmployee(subordinate);
        System.out.println(manager.toString());
        Manager updatedEmployee = managerDao.save(subordinate);
        Manager updatedManger = managerDao.save(manager);
        System.out.println(updatedEmployee.toString());
        return new ResponseEntity<Manager>(updatedManger, HttpStatus.OK);
    }

    @RequestMapping(value="/task", method=RequestMethod.PUT)
    public ResponseEntity<Employee> addTasktoEmployee(@RequestBody Map<String, String> payload) throws java.io.IOException {
        String employeeId = (String)payload.get("employeeId");
        String taskText = (String)payload.get("taskText");
        String dueDate = (String)payload.get("dueDate");
        Task task = new Task(taskText,dueDate, null);
        System.out.println(task.toString());
        Employee employeeData = employeeDao.findOne(Long.valueOf(employeeId));
        if(employeeData == null) {
            System.out.println("not found employee");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employeeData.addTask(task);
        System.out.println(employeeData.toString());
        Employee updatedEmployee = employeeDao.save(employeeData);
        System.out.println(updatedEmployee.toString());
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    @RequestMapping(value="/report", method=RequestMethod.PUT)
    public ResponseEntity<Manager> addReport(@RequestBody Map<String, String> payload) throws java.io.IOException {
        String bossId = payload.get("employeeId");
        String reportText = payload.get("reportText");
        Report report = new Report(reportText);
        System.out.println(report.toString());
        Manager employeeData = managerDao.findOne(Long.valueOf(bossId));
        if(employeeData == null) {
            System.out.println("not found employee");
            return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
        }
        employeeData.addReport(report);
        System.out.println(employeeData.toString());
        Manager updatedEmployee = managerDao.save(employeeData);
        System.out.println(updatedEmployee.toString());
        return new ResponseEntity<Manager>(updatedEmployee, HttpStatus.OK);
    }
    @RequestMapping(value="/{id}/manager", method=RequestMethod.GET)
    public ResponseEntity<Manager> getEmployeeManagerById(@PathVariable("id") String id) {
        Employee emp = employeeDao.findOne(Long.valueOf(id));
        if(emp == null) {
            return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Manager>(emp.getBoss(), HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map login(@RequestBody Map<String, Object> payload) throws java.io.IOException {
        if (payload.get("UserName") == "admin" && payload.get("password") == "123" ){
            HashMap<String,String> result = new HashMap<String,String>();
            result.put("Status","Ok");
            return result;
        }
        return payload;
    }

}