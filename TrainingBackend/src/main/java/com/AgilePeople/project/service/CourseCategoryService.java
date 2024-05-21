package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.CourseCategory;

import java.util.List;

public interface CourseCategoryService {
    CourseCategory createCourseCategory(CourseCategory coursecategory);

    CourseCategory getCourseCategoryById(Long coursecategoryId);

    List<CourseCategory> getAllCourseCategory();

    CourseCategory updateCourseCategory(CourseCategory coursecategory);

    void deleteCourseCategory(Long coursecategoryId);
}