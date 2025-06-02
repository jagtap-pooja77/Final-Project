package com.example.artisan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.artisan.model.Admin;
import com.example.artisan.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository repo;

    // create admin
    public Object registerAdmin(Admin admin) {
        try {

            repo.save(admin);
            return "Admin Register ";

        } catch (Exception e) {
            e.getMessage();
        }
        return "Admin Register ";
    }

    // get all Admin
    public List<Admin> getAllAdmin() {
        return repo.findAll();
    }

    // get admin by id
    public Object getAdminById(Long id) {
        return repo.findById(id);
    }

    // update admin data

    public Object updateAdmin(Long id, Admin admin) {
        try {
            Admin adminData = repo.findById(id).orElseThrow();
            adminData.setName(admin.getName());
            adminData.setEmail(admin.getEmail());
            adminData.setContact(admin.getContact());
            adminData.setPassword(admin.getPassword());
            adminData.setAddress(admin.getAddress());
            repo.save(adminData);
            return "Admin with id " + id + " updated.";
        } catch (Exception e) {
            e.getMessage();
        }
        return admin;
    }

    // delete admin
    public String deleteAdmin(Long id) {
        try {
            repo.deleteById(id);
            return "Successfully Admin deleted";
        } catch (Exception e) {
            e.getMessage();
        }
        return "Successfully Admin deleted";
    }

}
