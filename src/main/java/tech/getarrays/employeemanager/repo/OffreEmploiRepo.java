package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.OffreEmploi;

import java.util.Optional;

public interface OffreEmploiRepo extends JpaRepository<OffreEmploi , Long> {
    Optional<Object> findOffreEmploitById(Long id);

    void deleteOffreEmploiById(Long id);
}
