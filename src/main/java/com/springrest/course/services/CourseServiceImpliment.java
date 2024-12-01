package com.springrest.course.services;

import com.springrest.course.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.course.dao.courseDao;
import java.util.*;

@Service
public class CourseServiceImpliment implements CourseService{
    @Autowired
    private courseDao courseDao;

    public CourseServiceImpliment(){

    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public Optional<Course> getCourse(long courseId) {
        System.out.println("mayanak "+ courseDao.findById(courseId));
        return courseDao.findById(courseId);
    }
    @Override
    public Course deleteCourse(long courseId){
        Course course = courseDao.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

        // Delete the course
        courseDao.deleteById(courseId);

        // Return the deleted course
        return course;
    }

}
