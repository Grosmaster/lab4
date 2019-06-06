package com.lab.springboost.model.impl;

import com.google.common.collect.Lists;
import com.lab.springboost.jms.SenderMessage;
import com.lab.springboost.model.PatientsDAO;
import com.lab.springboost.repository.PatientsRepository;
import com.lab.springboost.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientsService implements PatientsDAO {
    @Autowired
    private PatientsRepository patientsRepository;

    @Override
    public void addPatient(PatientEntity patient) {
        SenderMessage.send("addPatient " + patient.toString());
        patientsRepository.save(patient);
    }

    @Override
    public void removePatient(PatientEntity patient) {
        SenderMessage.send("removePatient " + patient.toString());
        patientsRepository.delete(patient);
    }

    @Override
    public void editPatient(PatientEntity patient) {
        SenderMessage.send("editPatient " + patient.toString());
        patientsRepository.save(patient);
    }

    @Override
    public PatientEntity findById(Integer id) {
        return  patientsRepository.findById(id);
    }

    @Override
    public List<PatientEntity> allPatients() {
        return Lists.newArrayList(patientsRepository.findAll());
    }
}
