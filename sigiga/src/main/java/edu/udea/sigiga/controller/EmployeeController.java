package edu.udea.sigiga.controller;

import edu.udea.sigiga.exception.ModelNotFoundException;
import edu.udea.sigiga.model.Employee;
import edu.udea.sigiga.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    //Creamos un Bean de la EmployeeService
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "users")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @GetMapping(value = "users")
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @PutMapping(value = "users")
    public  Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long idEmployee){
        Employee employee = employeeService.findById(idEmployee);
        if(employee == null){
            throw new ModelNotFoundException("Empleado no encontrado");
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @DeleteMapping(value = "users")
    public String deleteEmployeee(@RequestParam long id){
        employeeService.deleteEmployee(id);
        return "Employee Deleted!";
    }
}
