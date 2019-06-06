package com.lab.springboost.model.impl;

import com.google.common.collect.Lists;
import com.lab.springboost.jms.SenderMessage;
import com.lab.springboost.model.DoctorsDAO;
import com.lab.springboost.repository.DoctorsRepository;
import com.lab.springboost.repository.PrescriptionsRepository;
import com.lab.springboost.entity.DoctorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorsService implements DoctorsDAO {
    @Autowired
    private DoctorsRepository doctorsRepository;

    @Autowired
    private PrescriptionsRepository prescriptionsRepository;

    @Override
    public void addDoctor(DoctorEntity doctor) {
        SenderMessage.send("addDoctor " + doctor.toString());
        doctorsRepository.save(doctor);
    }

    @Override
    public void removeDoctor(DoctorEntity doctor) {
        SenderMessage.send("removeDoctor " + doctor.toString());
        doctorsRepository.delete(doctor);
    }

    @Override
    public void editDoctor(DoctorEntity doctor) {
        SenderMessage.send("editDoctor " + doctor.toString());
        doctorsRepository.save(doctor);
    }

    @Override
    public DoctorEntity findById(Integer id) {
        return doctorsRepository.findById(id);
    }

    @Override
    public Integer prescriptionOfDoctor(Integer id) {
        return prescriptionsRepository.countByDoctorByIddoctor_Id(id);
    }

    @Override
    public List<DoctorEntity> allDoctors() {
        return Lists.newArrayList(doctorsRepository.findAll());
    }
}
