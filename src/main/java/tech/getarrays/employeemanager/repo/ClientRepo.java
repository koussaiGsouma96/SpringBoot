package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Client;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Long>
{

    Optional<Object> findClientById(Long id);

    void deleteClientById(Long id);
}
