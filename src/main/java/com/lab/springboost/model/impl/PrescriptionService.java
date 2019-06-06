package com.lab.springboost.model.impl;

import com.google.common.collect.Lists;
import com.lab.springboost.jms.SenderMessage;
import com.lab.springboost.model.PrescriptionDAO;
import com.lab.springboost.repository.PrescriptionsRepository;
import com.lab.springboost.entity.PrescriptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionService implements PrescriptionDAO {

    @Autowired
    private PrescriptionsRepository prescriptionsRepository;


    @Override
    public void addPrescription(PrescriptionEntity prescription) {
        SenderMessage.send("addPrescription " + prescription.toString());
        prescriptionsRepository.save(prescription);
    }

    @Override
    public void removePrescription(PrescriptionEntity prescription) {
        SenderMessage.send("removePrescription " + prescription.toString());
        prescriptionsRepository.deleteById(prescription.getId());
    }

    @Override
    public void editPrescription(PrescriptionEntity prescription) {
        SenderMessage.send("editPrescription " + prescription.toString());
        prescriptionsRepository.save(prescription);
    }

    @Override
    public List<PrescriptionEntity> allPrescription() {
        return Lists.newArrayList(prescriptionsRepository.findAll());
    }

    @Override
    public PrescriptionEntity findById(Integer id) {
        return prescriptionsRepository.findById(Long.valueOf(id)).get();
    }

}
