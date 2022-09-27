package edu.udea.sigiga.controller;

import edu.udea.sigiga.exception.ModelNotFoundException;
import edu.udea.sigiga.model.Employee;
import edu.udea.sigiga.service.EmployeeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EmployeeController {

    //Atributos
    EmployeeService employeeService;

    //Constructor
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Página mostrar Empleados
    @GetMapping("/employees")
    public String employees(Model model){
        List<Employee> employeeList = this.employeeService.findAllEmployees();
        model.addAttribute("employees", employeeList);
        return "employees";
    }

    //Página Nuevo Empleado
    @GetMapping("/employees/new")
    public String newEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "new-employee";
    }







    //Requests
    @GetMapping("users/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long idEmployee){
        Employee employee = employeeService.findById(idEmployee);
        if(employee == null){
            throw new ModelNotFoundException("Empleado no encontrado");
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/users")
    public RedirectView saveEmployee(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD")
                                         Employee employee, Model model){
        model.addAttribute(employee);
        this.employeeService.saveEmployee(employee);
        return new RedirectView("/users");
    }

    @PutMapping(value = "users")
    public  Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }


    @DeleteMapping(value = "users")
    public String deleteEmployeee(@RequestParam long id){
        employeeService.deleteEmployee(id);
        return "Employee Deleted!";
    }
}
