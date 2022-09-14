package edu.udea.sigiga.service;

import edu.udea.sigiga.model.Employee;
import edu.udea.sigiga.model.Profile;

import java.util.List;

public interface ProfileInterface {

    public Profile saveProfile(Profile profile);            //Create
    public Profile updateProfile(Profile profile);         //Update
    public Profile findById(String id);                     //Find by Id
    public List<Profile> findAllProfile();                  //Fetch
    //public void deleteProfile(String id);                    //Delete
}
