package com.AgilePeople.project.controller;

import com.AgilePeople.project.entity.Admission;
import com.AgilePeople.project.entity.Enquiry;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/admission")
public class AdmissionController {
    @Autowired
    private AdmissionService admissionService;
    //http://localhost:8080/api/admission
    @PostMapping
    public ResponseEntity<ResponsePojo> createAdmission(@RequestBody Admission admission) {
        String errorMsg = "";
        ResponsePojo responsePojo = null;
        if(admission != null)
        {
            if(admission.getFirstName() == null || admission.getFirstName().equals("")) {
                errorMsg = "First name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(admission.getLastName() == null || admission.getLastName().equals("")) {
                errorMsg = "Last name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }

            else if (admission.getMobile() == null || !admission.getMobile().matches("\\d{10}")) {
                errorMsg = "Invalid Mobile!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }

            else if(admission.getSex() == null || admission.getSex().equals("")) {
                errorMsg = "Sex is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (admission.getEmail() == null ||!admission.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (admission.getAadhar() == null ||!admission.getAadhar().matches("\\d{12}")) {
                errorMsg = "Inavlid Aadhar!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(admission.getEducation() == null || admission.getEducation().equals("")) {
                errorMsg = "Education is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(admission.getBranch() == null || admission.getBranch().equals("")) {
                errorMsg = "Branch is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(admission.getUploadAadhar() == null || admission.getUploadAadhar().equals("")) {
                errorMsg = "Uploaded Aadhar is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(admission.getUploadPhoto() == null || admission.getUploadPhoto().equals("")) {
                errorMsg = "Uploaded Photo is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(admission.getActive() == null || admission.getActive().equals("")) {
                errorMsg = "Active is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (admission.getCreated_by() == null || !admission.getCreated_by().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (admission.getUpdated_by() == null || !admission.getUpdated_by().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }

            else {
                Admission admissionData = admissionService.createAdmission(admission);
                responsePojo = new ResponsePojo();
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("Successfully posted");
               responsePojo.setData(admissionData);
            }
        }
        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/admission/{id}
    @GetMapping("{id}")
    public ResponseEntity<ResponsePojo> getAdmissionById(@PathVariable("id") Long admissionId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            Admission admission = admissionService.getAdmissionById(admissionId);
            if (admission != null) {
                responsePojo.setSuccess(true);
                responsePojo.setData(admission);
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No enquiry found with ID: " + admissionId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error occurred while retrieving the enquiry: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // http://localhost:8080/api/admission
    @GetMapping
    public ResponseEntity<List<Admission>> getAllAdmission(){
        List<Admission> admission = admissionService.getAllAdmission();
        return new ResponseEntity<>(admission, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponsePojo> updateAdmission(@PathVariable("id") Long admissionId,
                                                        @RequestBody Admission admission) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            if (admission != null) {
                if (admission.getFirstName() == null || admission.getFirstName().isEmpty()) {
                    String errorMsg = "First name is missing!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                } else if (admission.getLastName() == null || admission.getLastName().isEmpty()) {
                    String errorMsg = "Last name is missing!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                }
                else if(admission.getMobile() == null || admission.getMobile().equals("")) {
                    String errorMsg = "Mobile is missing!";
                    responsePojo = new ResponsePojo();
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                }
                else if (!admission.getMobile().matches("\\d{10}")) {
                    String errorMsg = "Invalid mobile number!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                }
                else if (admission.getSex() == null || admission.getSex().isEmpty()) {
                    String errorMsg = "Sex is missing!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                } else if (admission.getEmail() == null ||!admission.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    String errorMsg = "Invalid email format!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                } else if (admission.getAadhar() == null || !admission.getAadhar().matches("\\d{12}")) {
                    String errorMsg = "Invalid Aadhar number!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                } else if (admission.getEducation() == null || admission.getEducation().isEmpty()) {
                    String errorMsg = "Education is missing!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                } else if (admission.getBranch() == null || admission.getBranch().isEmpty()) {
                    String errorMsg = "Branch is missing!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                } else if (admission.getUploadAadhar() == null || admission.getUploadAadhar().isEmpty()) {
                    String errorMsg = "Uploaded Aadhar is missing!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                } else if (admission.getUploadPhoto() == null || admission.getUploadPhoto().isEmpty()) {
                    String errorMsg = "Uploaded Photo is missing!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                } else if (admission.getActive() == null || admission.getActive().isEmpty()) {
                    String errorMsg = "Active status is missing!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                }
                else if (admission.getCreated_by() == null ||!admission.getCreated_by().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    String errorMsg = "Invalid email format!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                }
                else if (admission.getUpdated_by() == null || !admission.getUpdated_by().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    String errorMsg = "Invalid email format!";
                    responsePojo.setError(true);
                    responsePojo.setErrorMessage(errorMsg);
                    return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
                }


                // All validations passed, proceed with updating admission
                admission.setId(admissionId);
                Admission updatedAdmission = admissionService.updateAdmission(admission);
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("Successfully updated admission with ID: " + admissionId);
                responsePojo.setData(updatedAdmission);
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                String errorMsg = "Admission data is missing!";
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
                return new ResponseEntity<>(responsePojo, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("Failed to update admission: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<ResponsePojo> deleteAdmission(@PathVariable("id") Long admissionId) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            Admission admission = admissionService.getAdmissionById(admissionId);
            if (admission != null) {
                admission.setActive("N"); // Change active status to 'N' instead of deleting
                admissionService.updateAdmission(admission); // Update the admission record
                responsePojo.setSuccess(true);
                responsePojo.setSuccessMsg("Admission record status successfully changed to inactive!");
                return new ResponseEntity<>(responsePojo, HttpStatus.OK);
            } else {
                responsePojo.setError(true);
                responsePojo.setErrorMessage("No admission record found with ID: " + admissionId);
                return new ResponseEntity<>(responsePojo, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responsePojo.setError(true);
            responsePojo.setErrorMessage("An error occurred while attempting to change the admission record status: " + e.getMessage());
            return new ResponseEntity<>(responsePojo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}