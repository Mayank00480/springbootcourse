package com.springrest.course.services;

import com.springrest.course.CourseApplication;
import com.springrest.course.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {

    List<Course> getCourses();
    Course addCourse(Course course);
    Optional<Course> getCourse(long courseId);
    Course deleteCourse(long courseId);
}
