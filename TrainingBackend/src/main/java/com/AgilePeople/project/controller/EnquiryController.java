package com.AgilePeople.project.controller;
import com.AgilePeople.project.entity.Admission;
import com.AgilePeople.project.entity.Enquiry;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/enquiry")

public class EnquiryController {
    @Autowired
    private EnquiryService enquiryService;

    //
    @PostMapping
    public ResponseEntity<ResponsePojo> createEnquiry(@RequestBody Enquiry enquiry) {
        String errorMsg = "";
        ResponsePojo responsePojo = new ResponsePojo();
        if(enquiry != null) {
            if(enquiry.getName() == null || enquiry.getName().equals("")) {
                errorMsg = "Name is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(enquiry.getMobile() == null || enquiry.getMobile().equals("")) {
                errorMsg = "Mobile is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (enquiry.getMobile() == null ||!enquiry.getMobile().matches("\\d{10}")) {
                errorMsg = "Invalid Contact Format";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(enquiry.getCourse() == null || enquiry.getCourse().equals("")) {
                errorMsg = "Course is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(enquiry.getActive() == null || enquiry.getActive().equals("")) {
                errorMsg = "Active is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (enquiry.getCreated_by() == null || !enquiry.getCreated_by().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (enquiry.getUpdated_by() == null ||!enquiry.getUpdated_by().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else {
                Enquiry enquiryData = enquiryService.createEnquiry(enquiry);
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("Record successfully saved.");
                responsePojo.setData(enquiryData);
            }
        } else {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("Enquiry object is null.");
        }
        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponsePojo> getEnquiryById(@PathVariable("id") Long enquiryId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            Enquiry enquiry = enquiryService.getEnquiryById(enquiryId);
            if (enquiry != null) {
                responsePojo.setSuccess(true);
                responsePojo.setData(enquiry);
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No enquiry found with ID: " + enquiryId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error occurred while retrieving the enquiry: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Enquiry>> getAllEnquiry(){
        List<Enquiry> enquiry = enquiryService.getAllEnquiry();
        return new ResponseEntity<>(enquiry, HttpStatus.OK);
    }

@PutMapping("{id}")
public ResponseEntity<ResponsePojo> updateEnquiry(@PathVariable("id") Long enquiryId,
                                                  @RequestBody Enquiry enquiry) {
    ResponsePojo responsePojo = new ResponsePojo();
    try {
        String errorMsg = validateEnquiry(enquiry);
        if (!errorMsg.isEmpty()) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage(errorMsg);
            return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
        }

        enquiry.setId(enquiryId);
        Enquiry updatedEnquiry = enquiryService.updateEnquiry(enquiry);
        responsePojo.setSuccess(true);
        responsePojo.setSuccessMsg("Successfully updated enquiry with ID: " + enquiryId);
        responsePojo.setData(updatedEnquiry);
        return new ResponseEntity<>(responsePojo, HttpStatus.OK);
    } catch (Exception e) {
        responsePojo.setError(true);
        responsePojo.setErrorMessage("Failed to update enquiry: " + e.getMessage());
        return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
    }
}

    private String validateEnquiry(Enquiry enquiry) {
        if(enquiry == null) {
            return "Enquiry object is null.";
        }
        if(enquiry.getName() == null || enquiry.getName().isEmpty()) {
            return "Name is missing!";
        }
        if(enquiry.getMobile() == null || enquiry.getMobile().isEmpty()) {
            return "Mobile is missing!";
        }
        if (enquiry.getMobile() == null ||!enquiry.getMobile().matches("\\d{10}")) {
            return "Invalid Contact Format";
        }
        if(enquiry.getCourse() == null || enquiry.getCourse().isEmpty()) {
            return "Course is missing!";
        }
        if (enquiry.getCreated_by() == null ||!enquiry.getCreated_by().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Invalid email format!";
        }
        if (enquiry.getUpdated_by() == null ||!enquiry.getUpdated_by().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Invalid email format!";
        }
        return "";
    }

    //http://localhost:8080/api/enquiry/3
    @DeleteMapping("{id}")
    public ResponseEntity<ResponsePojo> deleteEnquiry(@PathVariable("id") Long enquiryId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            Enquiry enquiry = enquiryService.getEnquiryById(enquiryId);
            if (enquiry != null) {
                enquiry.setActive("N"); // Change active status to 'N' instead of deleting
                enquiryService.updateEnquiry(enquiry); // Update the admission record
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("Enquiry record status successfully changed to inactive!");
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No enquiry record found with ID: " + enquiryId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error occurred while attempting to change the enquiry record status: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
