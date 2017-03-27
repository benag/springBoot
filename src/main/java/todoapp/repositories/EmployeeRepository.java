package todoapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import todoapp.models.*;

@Repository
public interface EmployeeRepository extends MongoRepository<Worker, String> {

    public List<Worker> findAll();
    public Worker findOne(String id);
    public Worker save(Worker emp);
    public void delete(Worker emp);
}
