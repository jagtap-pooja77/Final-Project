package com.example.artisan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.artisan.model.Admin;
import com.example.artisan.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService service;

     // ragister admin
    @PostMapping("/registeradmin")
    public Object registerAdmin(@RequestBody Admin admin) {
        return service.registerAdmin(admin);

    }


    // get all Admin
    @GetMapping("/getalladmin")
    public List<Admin> getAllAdmin() {
        return service.getAllAdmin();
    }

    // get Admin by id
    @GetMapping("getadmin/{id}")
    public Object getAdminById(@PathVariable Long id) {
        return service.getAdminById(id);

    }


    // update admin data
    @PutMapping("/updateadmin/{id}")
    public Object updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return service.updateAdmin(id, admin);
    }

    // delete admin data
    @DeleteMapping("/deleteadmin/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        return service.deleteAdmin(id);
    }

}
