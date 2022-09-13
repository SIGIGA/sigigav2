package edu.udea.sigiga.controller;

import edu.udea.sigiga.model.Employee;
import edu.udea.sigiga.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    //Creamos un Bean de la EmployeeService
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
}
