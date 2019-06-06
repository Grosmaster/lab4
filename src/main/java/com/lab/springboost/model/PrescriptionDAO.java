package com.lab.springboost.model;

import com.lab.springboost.entity.PrescriptionEntity;

import java.util.List;

public interface PrescriptionDAO {
    void addPrescription(PrescriptionEntity prescription);
    void removePrescription(PrescriptionEntity prescription);
    void editPrescription(PrescriptionEntity prescription);
    List<PrescriptionEntity> allPrescription();
    PrescriptionEntity findById(Integer id);
}
