package com.springrest.course.controller;

import com.springrest.course.entities.Course;
import com.springrest.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Secured("INSTRUCTOR")
public class coursecontroller {

    @Autowired
    CourseService CourseService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to Home Page";
    }

    @GetMapping("/instructor")
    public String instructor(){
        return "I am instructor";
    }

    @GetMapping("/student")
    public String student(){
        return "I am Student";
    }


    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.CourseService.getCourses();
    }
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.CourseService.addCourse(course);
    }
    @GetMapping("courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable String courseId){
        return this.CourseService.getCourse(Long.parseLong(courseId));
    }

    @DeleteMapping("courses/{courseId}")
    public Course deleteCourse(@PathVariable String courseId){
        return this.CourseService.deleteCourse(Long.parseLong(courseId));
    }
}
