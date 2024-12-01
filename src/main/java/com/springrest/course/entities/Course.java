package com.springrest.course.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor; // The user who created this course

    @ManyToMany
    @JoinTable(
            name = "enrollments",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> students; // Users enrolled in this course

    public Long getCourseId() {
        return courseId;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Set<User> getStudents() {
        return students;
    }

    public User getInstructor() {
        return instructor;
    }

    public String getDescription() {
        return description;
    }

    public String getCourseName() {
        return courseName;
    }
// Getters and Setters
}
