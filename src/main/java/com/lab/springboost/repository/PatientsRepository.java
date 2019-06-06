package com.lab.springboost.repository;

import com.lab.springboost.entity.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends CrudRepository<PatientEntity, Long> {
    PatientEntity findById(Integer id);
}
