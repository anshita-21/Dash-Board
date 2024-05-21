package com.AgilePeople.project.controller;

import com.AgilePeople.project.entity.CourseCategory;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/course_category")

public class CourseCategoryController {
    @Autowired
    private CourseCategoryService coursecategoryService;

    //
    @PostMapping
    public ResponseEntity<ResponsePojo> createCourseCategory(@RequestBody CourseCategory coursecategory) {
        String errorMsg = "";
        ResponsePojo responsePojo = new ResponsePojo();
        if(coursecategory != null) {
            if(coursecategory.getCode() == null || coursecategory.getCode().equals("")) {
                errorMsg = "Code is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(coursecategory.getCourseType() == null || coursecategory.getCourseType().equals("")) {
                errorMsg = "course type is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }

            else if(coursecategory.getHasSubCategory() == null || coursecategory.getHasSubCategory().equals("")) {
                errorMsg = "has sub category is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(coursecategory.getActive() == null || coursecategory.getActive().equals("")) {
                errorMsg = "Active is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (coursecategory.getCreatedBy() == null || !coursecategory.getCreatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (coursecategory.getUpdatedBy() == null ||!coursecategory.getUpdatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else {
                CourseCategory coursecategoryData = coursecategoryService.createCourseCategory(coursecategory);
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("Record successfully saved.");
                responsePojo.setData(coursecategoryData);
            }
        } else {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("CourseCategory object is null.");
        }
        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponsePojo> getCourseCategoryById(@PathVariable("id") Long coursecategoryId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            CourseCategory coursecategory = coursecategoryService.getCourseCategoryById(coursecategoryId);
            if (coursecategory != null) {
                responsePojo.setSuccess(true);
                responsePojo.setData(coursecategory);
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No course category found with ID: " + coursecategoryId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error occurred while retrieving the course category: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<CourseCategory>> getAllCourseCategory(){
        List<CourseCategory> coursecategory = coursecategoryService.getAllCourseCategory();
        return new ResponseEntity<>(coursecategory, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponsePojo> updateCourseCategory(@PathVariable("id") Long coursecategoryId,
                                                      @RequestBody CourseCategory coursecategory) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            String errorMsg = validateCourseCategory(coursecategory);
            if (!errorMsg.isEmpty()) {
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
                return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
            }

            coursecategory.setId(coursecategoryId);
            CourseCategory updatedCourseCategory = coursecategoryService.updateCourseCategory(coursecategory);
            responsePojo.setSuccess(true);
            responsePojo.setSuccessMsg("Successfully updated course category with ID: " + coursecategoryId);
            responsePojo.setData(updatedCourseCategory);
            return new ResponseEntity<>(responsePojo, HttpStatus.OK);
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("Failed to update course category: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
        }
    }

    private String validateCourseCategory(CourseCategory coursecategory) {
        if(coursecategory == null) {
            return "course category object is null.";
        }
        if(coursecategory.getCode() == null || coursecategory.getCode().isEmpty()) {
            return "code is missing!";
        }
        if(coursecategory.getCourseType() == null || coursecategory.getCourseType().isEmpty()) {
            return "course type is missing!";
        }

        if(coursecategory.getHasSubCategory() == null || coursecategory.getHasSubCategory().isEmpty()) {
            return "has Course is missing!";
        }
        if(coursecategory.getActive() == null || coursecategory.getActive().isEmpty()) {
            return "course type is missing!";
        }

        if (coursecategory.getCreatedBy() == null ||!coursecategory.getCreatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Invalid email format!";
        }
        if (coursecategory.getUpdatedBy() == null ||!coursecategory.getUpdatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Invalid email format!";
        }
        return "";
    }

    //http://localhost:8080/api/course_category/3
    @DeleteMapping("{id}")
    public ResponseEntity<ResponsePojo> deleteCourseCategory(@PathVariable("id") Long coursecategoryId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            CourseCategory coursecategory = coursecategoryService.getCourseCategoryById(coursecategoryId);
            if (coursecategory != null) {
                coursecategory.setActive("N");
                coursecategoryService.updateCourseCategory(coursecategory);
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("CourseCategory record status successfully changed to inactive!");
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No CourseCategory record found with ID: " + coursecategoryId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error occurred while attempting to change the CourseCategory record status: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
