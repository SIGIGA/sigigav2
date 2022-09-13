package edu.udea.sigiga.service;

import edu.udea.sigiga.model.Enterprise;
import edu.udea.sigiga.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService implements EnterpriseInterface{
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public Enterprise saveEnterprise(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise updateEnterprise(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    @Override
    public List<Enterprise> findAllEnterprises() {
        return (List<Enterprise>) enterpriseRepository.findAll();
    }

    @Override
    public void deleteEnterprise(long id) {
        enterpriseRepository.deleteById(id);
    }

    @Override
    public Enterprise findById(Long id) {
        Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(id);
        return enterpriseOptional.orElse(null);
    }
}
