package com.AgilePeople.project.repository;

import com.AgilePeople.project.entity.CourseSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSubCategoryRepository extends JpaRepository<CourseSubCategory, Long> {
    List<CourseSubCategory> findByActive(String active);
}