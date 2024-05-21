package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.CourseCategory;
import com.AgilePeople.project.entity.CourseSubCategory;
import com.AgilePeople.project.repository.CourseSubCategoryRepository;
import com.AgilePeople.project.service.CourseSubCategoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class CourseSubCategoryServiceImpl implements CourseSubCategoryService {
    @Autowired
    private CourseSubCategoryRepository coursesubcategoryRepository;

    @Override
    public CourseSubCategory createCourseSubCategory(CourseSubCategory coursesubcategory) {
        return coursesubcategoryRepository.save(coursesubcategory);
    }

    @Override
    public CourseSubCategory getCourseSubCategoryById(Long coursesubcategoryId) {
        Optional<CourseSubCategory> optionalCourseSubCategory = coursesubcategoryRepository.findById(coursesubcategoryId);
        return optionalCourseSubCategory.orElse(null);
    }

    @Override
    public List<CourseSubCategory> getAllCourseSubCategory() {
        //return coursesubcategoryRepository.findByActive("Y");
        List<CourseSubCategory> coursesubcategory = coursesubcategoryRepository.findByActive("Y");
        Collections.reverse(coursesubcategory);
        return coursesubcategory;
    }

    @Override
    public CourseSubCategory updateCourseSubCategory(@NotNull CourseSubCategory coursesubcategory) {
        CourseSubCategory existingCourseSubCategory = coursesubcategoryRepository.findById(coursesubcategory.getId()).get();
        existingCourseSubCategory.setCode(coursesubcategory.getCode());
        existingCourseSubCategory.setSubCategoryName(coursesubcategory.getSubCategoryName());
        existingCourseSubCategory.setDuration(coursesubcategory.getDuration());
        existingCourseSubCategory.setActive(coursesubcategory.getActive());
        existingCourseSubCategory.setCreatedBy(coursesubcategory.getCreatedBy());
        existingCourseSubCategory.setUpdatedBy(coursesubcategory.getUpdatedBy());
        CourseSubCategory updatedCourseSubCategory = coursesubcategoryRepository.save(existingCourseSubCategory);
        return updatedCourseSubCategory;
    }

    @Override
    public void deleteCourseSubCategory(Long coursesubcategoryId) {
        coursesubcategoryRepository.deleteById(coursesubcategoryId);
    }

    public CourseSubCategoryServiceImpl(CourseSubCategoryRepository coursesubcategoryRepository) {
        this.coursesubcategoryRepository = coursesubcategoryRepository;
    }
}
