package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Admission;
import com.AgilePeople.project.repository.AdmissionRepository;
import com.AgilePeople.project.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class AdmissionServiceImpl implements AdmissionService {
    @Autowired
    private AdmissionRepository admissionRepository;

    @Override
    public Admission createAdmission(Admission admission) {
        return admissionRepository.save(admission);
    }

    @Override
    public Admission getAdmissionById(Long admissionId) {
        Optional<Admission> optionalAdmission = admissionRepository.findById(admissionId);
        return optionalAdmission.get();
    }

    @Override
    public List<Admission> getAllAdmission() {

//        return admissionRepository.findAll();
       // return admissionRepository.findByActive("Y");
        List<Admission> admissions = admissionRepository.findByActive("Y");
        Collections.reverse(admissions);
        return admissions;
    }

    @Override
    public Admission updateAdmission(Admission admission) {
        Admission existingAdmission = admissionRepository.findById(admission.getId()).get();
        existingAdmission.setFirstName(admission.getFirstName());
        existingAdmission.setMiddleName(admission.getMiddleName());
        existingAdmission.setLastName(admission.getLastName());
        existingAdmission.setMobile(admission.getMobile());
        existingAdmission.setSex(admission.getSex());
        existingAdmission.setEmail(admission.getEmail());
        existingAdmission.setAadhar(admission.getAadhar());
        existingAdmission.setEducation(admission.getEducation());
        existingAdmission.setBranch(admission.getBranch());
        existingAdmission.setUploadPhoto(admission.getUploadPhoto());
        existingAdmission.setUploadPhoto(admission.getUploadAadhar());
        existingAdmission.setActive(admission.getActive());
        existingAdmission.setCreated_by(admission.getCreated_by());
        existingAdmission.setUpdated_by(admission.getUpdated_by());
        Admission updatedAdmission = admissionRepository.save(existingAdmission);
        return updatedAdmission;
    }

    @Override
    public void deleteAdmission(Long admissionId) {
        admissionRepository.deleteById(admissionId);
    }


}
