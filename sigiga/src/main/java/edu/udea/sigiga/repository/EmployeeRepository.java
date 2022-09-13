package edu.udea.sigiga.repository;

import edu.udea.sigiga.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
