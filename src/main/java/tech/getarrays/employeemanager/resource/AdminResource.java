package tech.getarrays.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Admin;
import tech.getarrays.employeemanager.model.Client;
import tech.getarrays.employeemanager.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminResource {
private final AdminService adminService;

    public AdminResource(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/add")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        Admin newAdmin = adminService.addAdmin(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Admin> updateAdmin (@RequestBody Admin admin){
        Admin updateAdmin = adminService.updateAdmin(admin);
        return new ResponseEntity<>(updateAdmin, HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable("id") Long id){
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
