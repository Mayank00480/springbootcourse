package com.springrest.course.controller;

import com.springrest.course.entities.User;
import com.springrest.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured("INSTRUCTOR")
public class usercontroller {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User addUser(@RequestBody User user){
        System.out.println("mayank " + user.getEmail() + user.getName());
        return this.userService.addUser(user);
    }
}
