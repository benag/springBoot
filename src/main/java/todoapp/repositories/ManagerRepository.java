package todoapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import todoapp.models.*;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {

    public List<Manager> findAll();
    public Manager findOne(String id);
    public Manager save(Manager emp);
    public void delete(Manager emp);
}
