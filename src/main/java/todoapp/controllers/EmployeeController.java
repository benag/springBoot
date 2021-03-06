package todoapp.controllers;

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

import todoapp.models.*;
import todoapp.repositories.*;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    ManagerRepository managerRepository;
    MemeoryRepository memeoryRepository;

    @RequestMapping(method=RequestMethod.GET)
//    public List<Worker> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
    public List<Worker> getAllEmployees() {
        return memeoryRepository.findAll();
    }


    @RequestMapping(method=RequestMethod.POST)
    public Worker createEmployee(@RequestBody Map<String, String> payload) {

        return employeeRepository.save(new Employee(payload.get("firstName"),payload.get("lastName"),payload.get("position")));
        //  return memeoryRepository.save(emp);

//        if (emp.getPosition() == "employee"){
//
//            return employeeRepository.save(new Employee(emp.getFirstName(),emp.getLastName(),emp.getPosition()));
//        }else{
//            return managerRepository.save(new Manager(emp.getFirstName(),emp.getLastName(),emp.getPosition()));
//        }

    }
    @RequestMapping(value="/manager", method=RequestMethod.POST)
    public Worker createManager(@RequestBody Map<String, String> payload) {

        return employeeRepository.save(new Manager(payload.get("firstName"),payload.get("lastName"),payload.get("position")));
        //  return memeoryRepository.save(emp);

//        if (emp.getPosition() == "employee"){
//
//            return employeeRepository.save(new Employee(emp.getFirstName(),emp.getLastName(),emp.getPosition()));
//        }else{
//            return managerRepository.save(new Manager(emp.getFirstName(),emp.getLastName(),emp.getPosition()));
//        }

    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public ResponseEntity<Worker> getEmployeeById(@PathVariable("id") String id) {
        Worker emp = memeoryRepository.findOne(id);
        if(emp == null) {
            return new ResponseEntity<Worker>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Worker>(emp, HttpStatus.OK);
        }
//        Worker emp = employeeRepository.findOne(id);
//        if(emp == null) {
//            return new ResponseEntity<Worker>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<Worker>(emp, HttpStatus.OK);
//        }
    }
//
//    @RequestMapping(value="/employee", method=RequestMethod.PUT)
//    public ResponseEntity<Employee> addEmployee(@RequestBody Map<String, String> payload) throws java.io.IOException {
//        String addToEmployeeId = payload.get("addToId");
//        String addEmployeeId = payload.get("addId");
//        Worker employeeData = memeoryRepository.findOne(addToEmployeeId);
//        if(employeeData == null) {
//            System.out.println("not found");
//            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//        }
//        System.out.println("found");
//        Employee subordinate = memeoryRepository.findOne(addEmployeeId);
//        subordinate.setBoss(employeeData);
//        employeeData.addEmployee(subordinate);
//        System.out.println(employeeData.toString());
//        Employee updatedEmployee = employeeRepository.save(employeeData);
//        System.out.println(updatedEmployee.toString());
//        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
//    }

//    @RequestMapping(value="/employee", method=RequestMethod.PUT)
//    public ResponseEntity<Employee> addEmployee(@RequestBody Map<String, String> payload) throws java.io.IOException {
//        String addToEmployeeId = payload.get("addToId");
//        String addEmployeeId = payload.get("addId");
//        System.out.println(addToEmployeeId);
//        System.out.println(addEmployeeId);
//        Employee employeeData = employeeRepository.findOne(addToEmployeeId);
//        if(employeeData == null) {
//            System.out.println("not found");
//            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//        }
//        System.out.println("found");
//        Employee subordinate = employeeRepository.findOne(addEmployeeId);
//        subordinate.setBoss(employeeData);
//        employeeData.addEmployee(subordinate);
//        System.out.println(employeeData.toString());
//        Employee updatedEmployee = employeeRepository.save(employeeData);
//        System.out.println(updatedEmployee.toString());
//        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
//    }

//    @RequestMapping(value="/task", method=RequestMethod.PUT)
//    public ResponseEntity<Employee> addTasktoEmployee(@RequestBody Map<String, String> payload) throws java.io.IOException {
//        String employeeId = (String)payload.get("employeeId");
//        String taskText = (String)payload.get("taskText");
//        String dueDate = (String)payload.get("dueDate");
//        Task task = new Task(taskText,dueDate, null);
//        System.out.println(task.toString());
//        Employee employeeData = employeeRepository.findOne(employeeId);
//        if(employeeData == null) {
//            System.out.println("not found employee");
//            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//        }
//        employeeData.addTask(task);
//        System.out.println(employeeData.toString());
//        Employee updatedEmployee = employeeRepository.save(employeeData);
//        System.out.println(updatedEmployee.toString());
//        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
//    }
//
//    @RequestMapping(value="/report", method=RequestMethod.PUT)
//    public ResponseEntity<Employee> addReport(@RequestBody Map<String, String> payload) throws java.io.IOException {
//        String bossId = payload.get("bossId");
//        String reportText = payload.get("reportText");
//        Report report = new Report(reportText);
//        System.out.println(report.toString());
//        Employee bossData = employeeRepository.findOne(bossId);
//        if(bossData == null) {
//            System.out.println("not found employee");
//            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//        }
//        bossData.addReport(report);
//        System.out.println(bossData.toString());
//        Employee updatedEmployee = employeeRepository.save(bossData);
//        System.out.println(updatedEmployee.toString());
//        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
//    }

//    @RequestMapping( method=RequestMethod.PUT)
//    public void updateEmployee(@Valid @RequestBody Employee emp) {
//        System.out.println(emp.toString());
////        Todo todoData = todoRepository.findOne(id);
////        if(todoData == null) {
////            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
////        }
////        todoData.setTitle(todo.getTitle());
////        todoData.setCompleted(todo.getCompleted());
////        Todo updatedTodo = todoRepository.save(todoData);
//        //return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
////        return new ResponseEntity<Employee>(null,HttpStatus.OK);
//    }

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
