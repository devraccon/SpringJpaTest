package com.devracoon.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devracoon.jpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    User findByUserId(String userId);
}