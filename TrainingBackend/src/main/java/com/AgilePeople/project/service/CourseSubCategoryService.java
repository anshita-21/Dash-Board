package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.CourseSubCategory;

import java.util.List;

public interface CourseSubCategoryService {
    CourseSubCategory createCourseSubCategory(CourseSubCategory coursesubcategory);

    CourseSubCategory getCourseSubCategoryById(Long coursesubcategoryId);

    List<CourseSubCategory> getAllCourseSubCategory();

    CourseSubCategory updateCourseSubCategory(CourseSubCategory coursesubcategory);

    void deleteCourseSubCategory(Long coursesubcategoryId);
}