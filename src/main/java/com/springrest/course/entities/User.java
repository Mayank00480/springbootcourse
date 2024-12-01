package com.springrest.course.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String email;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // INSTRUCTOR or STUDENT

    @ManyToMany(mappedBy = "students")
    private Set<Course> enrolledCourses; // Courses this user is enrolled in

    @OneToMany(mappedBy = "instructor")
    private Set<Course> createdCourses; // Courses this user created

    // Getters and Setters
    public enum Role {
        INSTRUCTOR, STUDENT
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public Set<Course> getCreatedCourses() {
        return createdCourses;
    }

    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public Role getRole() {
        return role;
    }

    public String getRoleAsString() {
        return role != null ? role.name() : null;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCreatedCourses(Set<Course> createdCourses) {
        this.createdCourses = createdCourses;
    }

    public void setEnrolledCourses(Set<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}

