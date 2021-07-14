package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {
    void deleteAdminById(Long id);
}
