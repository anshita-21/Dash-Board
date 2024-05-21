package com.AgilePeople.project.controller;

import com.AgilePeople.project.entity.Course;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/course")

public class CourseController {
    @Autowired
    private CourseService courseService;

    //
    @PostMapping
    public ResponseEntity<ResponsePojo> createCourse(@RequestBody Course course) {
        String errorMsg = "";
        ResponsePojo responsePojo = new ResponsePojo();
        if(course != null) {
            if(course.getCode() == null || course.getCode().equals("")) {
                errorMsg = "Code is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(course.getName() == null || course.getName().equals("")) {
                errorMsg = "name is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }

            else if(course.getDuration() == null || course.getDuration().equals("")) {
                errorMsg = "duration is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(course.getTotalSeats() == null || course.getTotalSeats().equals("")) {
                errorMsg = "total seats is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(course.getCourseCategoryId() == 0 ) {
                errorMsg = "course category id is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(course.getCourseSubCategoryId() == 0 ) {
                errorMsg = "course sub category is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(course.getFees() == null || course.getFees().equals("")) {
                errorMsg = "fees is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(course.getActive() == null || course.getActive().equals("")) {
                errorMsg = "Active is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (course.getCreatedBy() == null || !course.getCreatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (course.getUpdatedBy() == null || !course.getUpdatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else {
                Course courseData = courseService.createCourse(course);
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("Record successfully saved.");
                responsePojo.setData(courseData);
            }
        } else {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("Course object is null.");
        }
        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponsePojo> getCourseById(@PathVariable("id") Long courseId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            Course course = courseService.getCourseById(courseId);
            if (course != null) {
                responsePojo.setSuccess(true);
                responsePojo.setData(course);
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No course found with ID: " + courseId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error occurred while retrieving the course: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse(){
        List<Course> course = courseService.getAllCourse();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponsePojo> updateCourse(@PathVariable("id") Long courseId,
                                                             @RequestBody Course course) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            String errorMsg = validateCourse(course);
            if (!errorMsg.isEmpty()) {
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
                return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
            }

            course.setId(courseId);
            Course updatedCourse = courseService.updateCourse(course);
            responsePojo.setSuccess(true);
            responsePojo.setSuccessMsg("Successfully updated course with ID: " + courseId);
            responsePojo.setData(updatedCourse);
            return new ResponseEntity<>(responsePojo, HttpStatus.OK);
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("Failed to update course: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
        }
    }

    private String validateCourse(Course course) {
        if(course == null) {
            return "course object is null.";
        }
        if(course.getCode() == null || course.getCode().isEmpty()) {
            return "code is missing!";
        }
        if(course.getName() == null || course.getName().isEmpty()) {
            return "name is missing!";
        }
        if(course.getDuration() == null || course.getDuration().isEmpty()) {
            return "duration is missing!";
        }
        if(course.getTotalSeats() == null || course.getTotalSeats().isEmpty()) {
            return "total seats is missing!";
        }
        if(course.getCourseCategoryId() == 0) {
            return "cour category id is missing!";
        }
        if(course.getCourseSubCategoryId() == 0 ) {
            return "course sub category is missing!";
        }
        if(course.getFees() == null || course.getFees().isEmpty()) {
            return "fees is missing!";
        }
        if(course.getActive() == null || course.getActive().isEmpty()) {
            return "active is missing!";
        }

        if (course.getCreatedBy() == null || !course.getCreatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Invalid email format!";
        }
        if (course.getUpdatedBy() == null || !course.getUpdatedBy().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Invalid email format!";
        }
        return "";
    }

    //http://localhost:8080/api/course/3
    @DeleteMapping("{id}")
    public ResponseEntity<ResponsePojo> deleteCourse(@PathVariable("id") Long courseId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            Course course = courseService.getCourseById(courseId);
            if (course != null) {
                course.setActive("N");
                courseService.updateCourse(course);
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("CourseCategory record status successfully changed to inactive!");
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No CourseCategory record found with ID: " + courseId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error :" + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
