package com.springrest.course.dao;

import com.springrest.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
     User findByUsername(String username); //
}
