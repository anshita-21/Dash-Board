package com.AgilePeople.project.repository;

import com.AgilePeople.project.entity.Admission;
import com.AgilePeople.project.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
    List<Enquiry> findByActive(String active);
}