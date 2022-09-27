package edu.udea.sigiga.service;

import edu.udea.sigiga.model.Enterprise;
import edu.udea.sigiga.repository.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService{

    //Variable que implementa el repositorio
    private EnterpriseRepository enterpriseRepository;

    //Pasando repositorio al servicio
    public EnterpriseService(EnterpriseRepository enterpriseRepository){
        this.enterpriseRepository = enterpriseRepository;
    }

    //Obtener todos los Task de la base de datos
    public Enterprise saveEnterprise(Enterprise enterprise) {
        return this.enterpriseRepository.save(enterprise);
    }

    public Enterprise updateEnterprise(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    public List<Enterprise> findAllEnterprises() {
        return (List<Enterprise>) enterpriseRepository.findAll();
    }

    public void deleteEnterprise(long id) {
        enterpriseRepository.deleteById(id);
    }

    public Enterprise findById(Long id) {
        Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(id);
        return enterpriseOptional.orElse(null);
    }

    public Boolean deleteEnterprise(Long id){
        this.enterpriseRepository.deleteById(id);
        return true;
    }
}