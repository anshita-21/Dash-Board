package com.AgilePeople.project.controller;

import com.AgilePeople.project.entity.CourseSubCategory;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.CourseSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/course_sub_category")

public class CourseSubCategoryController {
    @Autowired
    private CourseSubCategoryService coursesubcategoryService;

    //
    @PostMapping
    public ResponseEntity<ResponsePojo> createCourseSubCategory(@RequestBody CourseSubCategory coursesubcategory) {
        String errorMsg = "";
        ResponsePojo responsePojo = new ResponsePojo();
        if(coursesubcategory != null) {
            if(coursesubcategory.getCode() == null || coursesubcategory.getCode().equals("")) {
                errorMsg = "Code is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(coursesubcategory.getSubCategoryName() == null || coursesubcategory.getSubCategoryName().equals("")) {
                errorMsg = "name is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }

            else if(coursesubcategory.getDuration() == null || coursesubcategory.getDuration().equals("")) {
                errorMsg = "duration is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(coursesubcategory.getActive() == null || coursesubcategory.getActive().equals("")) {
                errorMsg = "Active is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (coursesubcategory.getCreatedBy() == null ||!coursesubcategory.getCreatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (coursesubcategory.getUpdatedBy() == null ||!coursesubcategory.getUpdatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else {
                CourseSubCategory coursesubcategoryData = coursesubcategoryService.createCourseSubCategory(coursesubcategory);
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("Record successfully saved.");
                responsePojo.setData(coursesubcategoryData);
            }
        } else {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("CourseSubCategory object is null.");
        }
        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponsePojo> getCourseSubCategoryById(@PathVariable("id") Long coursesubcategoryId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            CourseSubCategory coursesubcategory = coursesubcategoryService.getCourseSubCategoryById(coursesubcategoryId);
            if (coursesubcategory != null) {
                responsePojo.setSuccess(true);
                responsePojo.setData(coursesubcategory);
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No course sub category found with ID: " + coursesubcategoryId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error occurred while retrieving the course sub category: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<CourseSubCategory>> getAllCourseSubCategory(){
        List<CourseSubCategory> coursesubcategory = coursesubcategoryService.getAllCourseSubCategory();
        return new ResponseEntity<>(coursesubcategory, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponsePojo> updateCourseSubCategory(@PathVariable("id") Long coursesubcategoryId,
                                                             @RequestBody CourseSubCategory coursesubcategory) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            String errorMsg = validateCourseSubCategory(coursesubcategory);
            if (!errorMsg.isEmpty()) {
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
                return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
            }

            coursesubcategory.setId(coursesubcategoryId);
            CourseSubCategory updatedCourseSubCategory = coursesubcategoryService.updateCourseSubCategory(coursesubcategory);
            responsePojo.setSuccess(true);
            responsePojo.setSuccessMsg("Successfully updated course sub category with ID: " + coursesubcategoryId);
            responsePojo.setData(updatedCourseSubCategory);
            return new ResponseEntity<>(responsePojo, HttpStatus.OK);
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("Failed to update course sub category: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
        }
    }

    private String validateCourseSubCategory(CourseSubCategory coursesubcategory) {
        if(coursesubcategory == null) {
            return "course sub category object is null.";
        }
        if(coursesubcategory.getCode() == null || coursesubcategory.getCode().isEmpty()) {
            return "code is missing!";
        }
        if(coursesubcategory.getSubCategoryName() == null || coursesubcategory.getSubCategoryName().isEmpty()) {
            return "course sub category is missing!";
        }

        if(coursesubcategory.getDuration() == null || coursesubcategory.getDuration().isEmpty()) {
            return "duration is missing!";
        }
        if(coursesubcategory.getActive() == null || coursesubcategory.getActive().isEmpty()) {
            return "active is missing!";
        }
        if (coursesubcategory.getCreatedBy() == null || !coursesubcategory.getCreatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Invalid email format!";
        }
        if (coursesubcategory.getUpdatedBy() == null || !coursesubcategory.getUpdatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Invalid email format!";
        }
        return "";
    }

    //http://localhost:8080/api/course_sub_category/3
    @DeleteMapping("{id}")
    public ResponseEntity<ResponsePojo> deleteCourseSubCategory(@PathVariable("id") Long coursesubcategoryId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            CourseSubCategory coursesubcategory = coursesubcategoryService.getCourseSubCategoryById(coursesubcategoryId);
            if (coursesubcategory != null) {
                coursesubcategory.setActive("N");
                coursesubcategoryService.updateCourseSubCategory(coursesubcategory);
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("CourseSubCategory record status successfully changed to inactive!");
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No CourseSubCategory record found with ID: " + coursesubcategoryId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error occurred while attempting to change the CourseSubCategory record status: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
