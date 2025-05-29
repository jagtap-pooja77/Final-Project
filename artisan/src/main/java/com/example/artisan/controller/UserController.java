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

import com.example.artisan.model.User;
import com.example.artisan.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

      //get all user
    @GetMapping("/getalluser")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

     //get user by id
     @GetMapping("getuser/{id}")
    public Object getUserById(@PathVariable Long id) {
        return service.getUserById(id);
                
    }
   
    @PostMapping("/registeruser")
    public Object registerUser(@RequestBody User user){
     return service.registerUser(user);
    
    }

    @PutMapping("/updateuser/{id}")
    public Object updateUser(@PathVariable Long id, @RequestBody User user){
        return service.updateUser(id, user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteuser(@PathVariable Long id){
        return service.deleteUser(id);
    }


}
