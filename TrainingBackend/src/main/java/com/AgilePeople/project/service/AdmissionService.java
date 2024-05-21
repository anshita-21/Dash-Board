package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.Admission;

import java.util.List;

public interface AdmissionService {
    Admission createAdmission(Admission admission);

    Admission getAdmissionById(Long admissionId);

    List<Admission> getAllAdmission();

    Admission updateAdmission(Admission admission);

    void deleteAdmission(Long admissionId);
}