package com.mergency.crudapi.services;

import com.mergency.crudapi.entity.User;
import java.util.*;

public interface UserServices {
    User save(User user);

    List<User> findAll();

    User findByID(Integer id);

    void deleteByID(Integer id);
}