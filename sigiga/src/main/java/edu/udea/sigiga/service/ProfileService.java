package edu.udea.sigiga.service;

import edu.udea.sigiga.model.Employee;
import edu.udea.sigiga.model.Profile;
import edu.udea.sigiga.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService implements ProfileInterface{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile findById(String id) {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        return profileOptional.orElse(null);
    }

    @Override
    public List<Profile> findAllProfile() {
        return (List<Profile>) profileRepository.findAll();
    }

   }
