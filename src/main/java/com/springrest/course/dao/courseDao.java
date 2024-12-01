package com.springrest.course.dao;

import com.springrest.course.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseDao extends JpaRepository<Course ,Long> {

}
