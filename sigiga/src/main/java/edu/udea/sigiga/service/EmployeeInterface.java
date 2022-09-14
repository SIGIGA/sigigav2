package edu.udea.sigiga.service;

import edu.udea.sigiga.model.Employee;
import edu.udea.sigiga.model.Enterprise;

import java.util.List;

public interface EmployeeInterface {
    //Declaración de métodos
    public Employee saveEmployee(Employee employee);        //Create
    public Employee updateEmployee(Employee employee);      //Update
    public Employee findById(Long id);                      //Find by Id
    public List<Employee> findAllEmployees();               //Fetch
    public void deleteEmployee(long id);                    //Delete
}
