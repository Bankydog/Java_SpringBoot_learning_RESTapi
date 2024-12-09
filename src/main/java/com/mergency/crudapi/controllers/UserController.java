package com.mergency.crudapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mergency.crudapi.entity.User;
import com.mergency.crudapi.services.UserServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/post")
    public User postUser(@RequestBody User user) {
        user.setID(0);
        return userServices.save(user);
    }

    @GetMapping("/get")
    public List<User> getAllUser() {
        return userServices.findAll();
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable int id) {
        User myUser = userServices.findByID(id);
        if (myUser == null) {
            throw new RuntimeException("Cant find a ID : " + id);
        }
        return myUser;

    }

    @DeleteMapping("/get/{id}")
    public String deleteUser(@PathVariable int id) {
        User myUser = userServices.findByID(id);
        if (myUser == null) {
            throw new RuntimeException("Cant find a ID : " + id);
        }
        userServices.deleteByID(id);
        return "Delete ID : " + id + " Complete";
    }

    @PutMapping("/get")
    public User updateUser(@RequestBody User user) {
        return userServices.save(user);
    }
}
