package com.lab.springboost.model;

import com.lab.springboost.entity.PatientEntity;

import java.util.List;

public interface PatientsDAO {
    void addPatient(PatientEntity patient);
    void removePatient(PatientEntity patient);
    void editPatient(PatientEntity patient);
    PatientEntity findById(Integer id);
    List<PatientEntity> allPatients();
}
