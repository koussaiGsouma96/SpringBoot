package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(long id);

    Optional<Object> findEmployeeById(Long id);

  //  Employee save(Employee employee, Employee empl);
}
