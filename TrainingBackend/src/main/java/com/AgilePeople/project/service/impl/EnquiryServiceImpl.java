package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.CourseCategory;
import com.AgilePeople.project.entity.Enquiry;
import com.AgilePeople.project.repository.EnquiryRepository;
import com.AgilePeople.project.service.EnquiryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {
    @Autowired
    private EnquiryRepository enquiryRepository;

    @Override
    public Enquiry createEnquiry(Enquiry enquiry) {
        return enquiryRepository.save(enquiry);
    }

    @Override
    public Enquiry getEnquiryById(Long enquiryId) {
        Optional<Enquiry> optionalEnquiry = enquiryRepository.findById(enquiryId);
        return optionalEnquiry.orElse(null);
    }
//    public Enquiry getEnquiryById(Long enquiryId) {
//        Optional<Enquiry> optionalEnquiry = enquiryRepository.findById(enquiryId);
//        return optionalEnquiry.get();
//    }

    @Override
    public List<Enquiry> getAllEnquiry() {

//        return enquiryRepository.findAll();
        //return enquiryRepository.findByActive("Y");
        List<Enquiry> enquiry = enquiryRepository.findByActive("Y");
        Collections.reverse(enquiry);
        return enquiry;
    }

    @Override
    public Enquiry updateEnquiry(@NotNull Enquiry enquiry) {
        Enquiry existingEnquiry = enquiryRepository.findById(enquiry.getId()).get();
        existingEnquiry.setName(enquiry.getName());
        existingEnquiry.setMobile(enquiry.getMobile());
        existingEnquiry.setCourse(enquiry.getCourse());
        existingEnquiry.setMessage(enquiry.getMessage());
        existingEnquiry.setActive(enquiry.getActive());
        existingEnquiry.setCreated_by(enquiry.getCreated_by());
        existingEnquiry.setUpdated_by(enquiry.getUpdated_by());
        Enquiry updatedEnquiry = enquiryRepository.save(existingEnquiry);
        return updatedEnquiry;
    }

    @Override
    public void deleteEnquiry(Long enquiryId) {
        enquiryRepository.deleteById(enquiryId);
    }

    public EnquiryServiceImpl(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }
}
