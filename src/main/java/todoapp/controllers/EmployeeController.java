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

import todoapp.models.Employee;
import todoapp.classes.Task;
import todoapp.models.Manager;
import todoapp.repositories.EmployeeRepository;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(method=RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST)
    public Employee createEmployee(@Valid @RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        Employee emp = employeeRepository.findOne(id);
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
        Employee employeeData = employeeRepository.findOne(addToEmployeeId);
        if(employeeData == null) {
            System.out.println("not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        System.out.println("found");
        Employee subordinate = employeeRepository.findOne(addEmployeeId);
        employeeData.addEmployee(subordinate);
        System.out.println(employeeData.toString());
        Employee updatedEmployee = employeeRepository.save(employeeData);
        System.out.println(updatedEmployee.toString());
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    @RequestMapping(value="/task", method=RequestMethod.PUT)
    public ResponseEntity<Employee> addTasktoEmployee(@RequestBody Map<String, String> payload) throws java.io.IOException {
        String employeeId = (String)payload.get("employeeId");
        String taskText = (String)payload.get("taskText");
        String dueDate = (String)payload.get("dueDate");
        Task task = new Task(taskText,dueDate);
        System.out.println(task.toString());
        Employee employeeData = employeeRepository.findOne(employeeId);
        if(employeeData == null) {
            System.out.println("not found employee");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employeeData.addTask(task);
        System.out.println(employeeData.toString());
        Employee updatedEmployee = employeeRepository.save(employeeData);
        System.out.println(updatedEmployee.toString());
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

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
