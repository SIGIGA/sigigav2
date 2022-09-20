package edu.udea.sigiga.controller;

import edu.udea.sigiga.exception.ModelNotFoundException;
import edu.udea.sigiga.model.Enterprise;
import edu.udea.sigiga.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin("*")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping(value = "enterprises")
    public Enterprise saveEnterprise(@RequestBody Enterprise enterprise){
        enterpriseService.saveEnterprise(enterprise);
        return enterprise;
    }

   /* @GetMapping("/enterprises")
    public List<Enterprise> findAllEnterprises(){
        return enterpriseService.findAllEnterprises();
    }
*/
    @PutMapping(value = "enterprises")
    public  Enterprise updateEnterprise(@RequestBody Enterprise enterprise){
        return enterpriseService.updateEnterprise(enterprise);
    }

    @DeleteMapping(value = "enterprises")
    public String deleteEnterprise(@RequestParam long id){
        enterpriseService.deleteEnterprise(id);
        return "Enterprise Deleted!";
    }

    @GetMapping("enterprises/{id}")
    public ResponseEntity<Enterprise> findById(@PathVariable("id") Long idEnterprise){
        Enterprise enterprise = enterpriseService.findById(idEnterprise);
        if(enterprise == null){
            throw new ModelNotFoundException("Cliente no encontrado");
        }
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }


}
