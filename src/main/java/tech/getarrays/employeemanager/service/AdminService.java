package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.model.Admin;
import tech.getarrays.employeemanager.model.Client;
import tech.getarrays.employeemanager.repo.AdminRepo;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private final AdminRepo adminRepo;

    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }
    public Admin addAdmin(Admin admin){
        return adminRepo.save(admin);
    }
    public Admin updateAdmin(Admin admin){return adminRepo.save(admin);}
    public void deleteAdmin(Long id){adminRepo.deleteAdminById(id);}
}
