package com.example.artisan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.artisan.model.User;
import com.example.artisan.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    // create user
    public Object registerUser(User user) {
        try {

            repo.save(user);
            return "User Register ";

        } catch (Exception e) {
            e.getMessage();
        }
        return "User Register ";
    }

    // get all user
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // get user by id
    public Object getUserById(Long id) {
        return repo.findById(id);
    }

    // update user data

    public Object updateUser(Long id, User user) {
        try {
            User userData = repo.findById(id).orElseThrow();
            userData.setName(user.getName());
            userData.setEmail(user.getEmail());
            userData.setUsername(user.getUsername());
            userData.setPassword(user.getPassword());

            repo.save(userData);
            return "User with id " + id + " updated.";
        } catch (Exception e) {
            e.getMessage();
        }
        return user;
    }

    // delete user
    public String deleteUser(Long id) {
        repo.deleteById(id);
        return "Successfully User deleted";
    }

}
