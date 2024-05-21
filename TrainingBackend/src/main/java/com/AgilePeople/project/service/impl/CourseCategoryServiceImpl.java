package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Admission;
import com.AgilePeople.project.entity.CourseCategory;
import com.AgilePeople.project.repository.CourseCategoryRepository;
import com.AgilePeople.project.service.CourseCategoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class CourseCategoryServiceImpl implements CourseCategoryService {
    @Autowired
    private CourseCategoryRepository coursecategoryRepository;

    @Override
    public CourseCategory createCourseCategory(CourseCategory coursecategory) {
        return coursecategoryRepository.save(coursecategory);
    }

    @Override
    public CourseCategory getCourseCategoryById(Long coursecategoryId) {
        Optional<CourseCategory> optionalCourseCategory = coursecategoryRepository.findById(coursecategoryId);
        return optionalCourseCategory.orElse(null);
    }

    @Override
    public List<CourseCategory> getAllCourseCategory() {
        //return coursecategoryRepository.findByActive("Y");
        List<CourseCategory> coursecategory = coursecategoryRepository.findByActive("Y");
        Collections.reverse(coursecategory);
        return coursecategory;
    }

    @Override
    public CourseCategory updateCourseCategory(@NotNull CourseCategory coursecategory) {
        CourseCategory existingCourseCategory = coursecategoryRepository.findById(coursecategory.getId()).get();
        existingCourseCategory.setCode(coursecategory.getCode());
        existingCourseCategory.setCourseType(coursecategory.getCourseType());
        existingCourseCategory.setHasSubCategory(coursecategory.getHasSubCategory());
        existingCourseCategory.setActive(coursecategory.getActive());
        existingCourseCategory.setCreatedBy(coursecategory.getCreatedBy());
        existingCourseCategory.setUpdatedBy(coursecategory.getUpdatedBy());
        CourseCategory updatedCourseCategory = coursecategoryRepository.save(existingCourseCategory);
        return updatedCourseCategory;
    }

    @Override
    public void deleteCourseCategory(Long coursecategoryId) {
        coursecategoryRepository.deleteById(coursecategoryId);
    }

    public CourseCategoryServiceImpl(CourseCategoryRepository coursecategoryRepository) {
        this.coursecategoryRepository = coursecategoryRepository;
    }
}
