package com.mergency.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mergency.crudapi.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
}
