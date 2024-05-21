package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);

    Course getCourseById(Long courseId);

    List<Course> getAllCourse();

    Course updateCourse(Course course);

    void deleteCourse(Long courseId);
}