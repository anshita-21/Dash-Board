package com.AgilePeople.project.repository;

import com.AgilePeople.project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByActive(String active);
}