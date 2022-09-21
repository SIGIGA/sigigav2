package edu.udea.sigiga.repository;

import edu.udea.sigiga.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}
