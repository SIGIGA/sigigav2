package edu.udea.sigiga.controller;

import edu.udea.sigiga.exception.ModelNotFoundException;
import edu.udea.sigiga.model.Employee;
import edu.udea.sigiga.model.Profile;
import edu.udea.sigiga.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping(value = "profile")
    public Profile saveProfile(@RequestBody Profile profile){
        profileService.saveProfile(profile);
        return profile;
    }

    @GetMapping(value = "profile")
    public List<Profile> findAllProfiles(){
        return profileService.findAllProfile();
    }

    @PutMapping(value = "profile")
    public  Profile updateProfile(@RequestBody Profile profile){
        return profileService.updateProfile(profile);
    }

    @GetMapping("profile/{id}")
    public ResponseEntity<Profile> findById(@PathVariable("id") String idProfile){
        Profile profile = profileService.findById(idProfile);
        if(profile == null){
            throw new ModelNotFoundException("Perfil no encontrado");
        }
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }


}
