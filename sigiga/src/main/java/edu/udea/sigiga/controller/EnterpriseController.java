package edu.udea.sigiga.controller;

import edu.udea.sigiga.exception.ModelNotFoundException;
import edu.udea.sigiga.model.Enterprise;
import edu.udea.sigiga.service.EnterpriseService;
import org.springframework.boot.Banner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.Id;
import java.util.List;

@RestController
public class EnterpriseController {

    //Atributos
    EnterpriseService enterpriseService;

    //Constructor
    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    //Request tipo POST
    @PostMapping("/enterprises")
    public RedirectView saveEnterprise(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD")
                                       Enterprise enterprise, Model model){
        model.addAttribute(enterprise);
        this.enterpriseService.saveEnterprise(enterprise);
        return new RedirectView("/enterprises");
    }

    @PutMapping(value = "enterprises")
    public  Enterprise updateEnterprise(@RequestBody Enterprise enterprise){
        return enterpriseService.updateEnterprise(enterprise);
    }

    @GetMapping("enterprises/{id}")
    public ResponseEntity<Enterprise> findById(@PathVariable("id") Long idEnterprise){
        Enterprise enterprise = enterpriseService.findById(idEnterprise);
        if(enterprise == null){
            throw new ModelNotFoundException("Cliente no encontrado");
        }
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

    //Controlador para borrar
    @GetMapping("enterprises/delete/{id}")
    public RedirectView deleteEnterprise(@PathVariable("id") Long id){
        this.enterpriseService.deleteEnterprise(id);
        return new RedirectView("/enterprises");
    }

}