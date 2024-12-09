package com.mergency.crudapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mergency.crudapi.entity.User;
import com.mergency.crudapi.repository.UserRepo;
import java.util.*;

import javax.management.RuntimeErrorException;

@Service
public class UserAction implements UserServices {

    private UserRepo userRepo;

    @Autowired
    public UserAction(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByID(Integer id) {
        Optional<User> result = userRepo.findById(id);
        User data = null;
        if (result.isPresent()) {
            data = result.get();
        } else {
            throw new RuntimeException("Cant find a ID : " + id);
        }
        return data;
    }

    @Override
    public void deleteByID(Integer id) {
        userRepo.deleteById(id);
    }
}
