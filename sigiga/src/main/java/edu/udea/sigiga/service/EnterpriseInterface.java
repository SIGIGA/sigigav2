package edu.udea.sigiga.service;

import edu.udea.sigiga.model.Enterprise;

import java.util.List;

public interface EnterpriseInterface {
    //Declaración de métodos
    public Enterprise saveEnterprise(Enterprise enterprise);        //Create
    public Enterprise updateEnterprise(Enterprise enterprise);      //Update
    public Enterprise findById(Long id);                            //Find by Id
    public List<Enterprise> findAllEnterprises();                   //Fetch
    public void deleteEnterprise(long id);                          //Delete
}
