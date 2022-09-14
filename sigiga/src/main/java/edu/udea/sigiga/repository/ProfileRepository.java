package edu.udea.sigiga.repository;

import edu.udea.sigiga.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, String> {
}
