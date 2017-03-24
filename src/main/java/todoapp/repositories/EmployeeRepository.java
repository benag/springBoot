package todoapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import todoapp.models.Employee;
import todoapp.classes.Worker;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public List<Employee> findAll();
    public Employee findOne(String id);
    public Employee save(Employee emp);
    public void delete(Employee emp);
}
