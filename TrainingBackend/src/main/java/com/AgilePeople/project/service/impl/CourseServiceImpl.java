package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Course;
import com.AgilePeople.project.entity.CourseCategory;
import com.AgilePeople.project.repository.CourseRepository;
import com.AgilePeople.project.service.CourseService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        return optionalCourse.orElse(null);
    }

    @Override
    public List<Course> getAllCourse() {
        //return courseRepository.findByActive("Y");
        List<Course> course = courseRepository.findByActive("Y");
        Collections.reverse(course);
        return course;
    }

    @Override
    public Course updateCourse(@NotNull Course course) {
        Course existingCourse = courseRepository.findById(course.getId()).get();
        existingCourse.setCode(course.getCode());
        existingCourse.setName(course.getName());
        existingCourse.setDuration(course.getDuration());
        existingCourse.setTotalSeats(course.getTotalSeats());
        existingCourse.setCourseCategoryId(course.getCourseCategoryId());
        existingCourse.setCourseSubCategoryId(course.getCourseSubCategoryId());
        existingCourse.setFees(course.getFees());
        existingCourse.setActive(course.getActive());
        existingCourse.setCreatedBy(course.getCreatedBy());
        existingCourse.setUpdatedBy(course.getUpdatedBy());
        Course updatedCourse = courseRepository.save(existingCourse);
        return updatedCourse;
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
