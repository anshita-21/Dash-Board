package com.AgilePeople.project.repository;

import com.AgilePeople.project.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {
    List<Admission> findByActive(String active);
}