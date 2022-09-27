package edu.udea.sigiga.controller;

import edu.udea.sigiga.model.Enterprise;
import edu.udea.sigiga.service.EmployeeService;
import edu.udea.sigiga.service.EnterpriseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FrontController {

    EnterpriseService enterpriseService;
    EmployeeService employeeService;

    //Constructores
    public FrontController(EnterpriseService enterpriseService){
        this.enterpriseService = enterpriseService;
    }

    //Página raíz del proyecto
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //Página mostrar empresas
    @GetMapping("/enterprises")
    public String enterprises(Model model){
        List<Enterprise> enterpriseList = this.enterpriseService.findAllEnterprises();
        model.addAttribute("enterprises", enterpriseList);
        return "enterprises";
    }



    //Página Nueva Empresa
    @GetMapping("/enterprises/new")
    public String newEnterprise(Model model){
        model.addAttribute("enterprise", new Enterprise());
        return "new-enterprise";
    }

    //Controlador para editar (Mostrar formulario para editar)
    @GetMapping("/enterprises/edit/{id}")
    public String editEnterprise(@PathVariable Long id, Model model){
        model.addAttribute("enterprise", enterpriseService.findById(id));
        return "edit-enterprise";
    }

    //Controlador para actualizar después de modificar
    @PostMapping("/enterprises/{id}")
    public String updateEnterprise(@PathVariable Long id, @ModelAttribute("enterprise")
    Enterprise enterprise, Model model){
        Enterprise enterpriseExistente = enterpriseService.findById(id);
        enterpriseExistente.setId(id);
        enterpriseExistente.setName(enterprise.getName());
        enterpriseExistente.setDocument(enterprise.getDocument());
        enterpriseExistente.setPhone(enterprise.getPhone());
        enterpriseExistente.setAddress(enterprise.getAddress());
        enterpriseExistente.setCreateAt(enterprise.getCreateAt());

        enterpriseService.updateEnterprise(enterpriseExistente);

        return "redirect:/enterprises";
    }

}