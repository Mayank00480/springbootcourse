package com.springrest.course.services;

import com.springrest.course.dao.UserDao;
import com.springrest.course.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplimentation implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user){
        System.out.println("mayank2"+user);
      userDao.save(user);
      return user;
    }
}
