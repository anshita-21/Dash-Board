package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.Enquiry;

import java.util.List;

public interface EnquiryService {
    Enquiry createEnquiry(Enquiry enquiry);

    Enquiry getEnquiryById(Long enquiryId);

    List<Enquiry> getAllEnquiry();

    Enquiry updateEnquiry(Enquiry enquiry);

    void deleteEnquiry(Long enquiryId);
}