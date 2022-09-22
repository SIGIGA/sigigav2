package edu.udea.sigiga.controller;

import edu.udea.sigiga.model.Enterprise;
import edu.udea.sigiga.service.EnterpriseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontController {

    EnterpriseService enterpriseService;

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

    @GetMapping("/enterprises/edit/{id}")
    public String updateEnterprise(){
        return "update-enterprise";
    }
}