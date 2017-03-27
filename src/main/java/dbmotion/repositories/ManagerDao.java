package dbmotion.repositories;

import org.springframework.data.repository.CrudRepository;
import dbmotion.models.Employee;
import dbmotion.models.Manager;

import javax.transaction.Transactional;

/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 * @author netgloo
 */
@Transactional
public interface ManagerDao extends CrudRepository<Manager, Long> {

  /**
   * Return the user having the passed email or null if no user is found.
   *
   */
  public Employee findByFirstName(String firstName);


} // class EmployeeDao