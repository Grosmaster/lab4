package com.lab.springboost.model;

import com.lab.springboost.entity.DoctorEntity;

import java.util.List;

public interface DoctorsDAO {
    void addDoctor(DoctorEntity doctor);
    void removeDoctor(DoctorEntity doctor);
    void editDoctor(DoctorEntity doctor);
    DoctorEntity findById(Integer id);
    Integer prescriptionOfDoctor(Integer id);
    List<DoctorEntity> allDoctors();
}
