package com.lab.springboost.Controller;

import com.lab.springboost.entity.DoctorEntity;
import com.lab.springboost.entity.PatientEntity;
import com.lab.springboost.model.DoctorsDAO;
import com.lab.springboost.model.PatientsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("patient")
public class PatientsController {
    @Autowired
    private PatientsDAO patientsDAO;

    @GetMapping(produces = { APPLICATION_JSON_VALUE,
            APPLICATION_XML_VALUE })
    public Object allPatients()  {
        return  patientsDAO.allPatients();
    }

    @GetMapping(value = "{id}", produces = { APPLICATION_JSON_VALUE,
            APPLICATION_XML_VALUE })
    public Object findById(@PathVariable int id) {
        return  patientsDAO.findById(id);
    }

    @DeleteMapping("{id}")
    public void removePatient(@PathVariable int id) {
        patientsDAO.removePatient(patientsDAO.findById(id));
    }

    @PostMapping
    public void createPatient(@RequestBody PatientEntity patientEntity) {
        patientsDAO.addPatient(patientEntity);
    }

    @PutMapping
    public void editPatient(@RequestBody PatientEntity patientEntity) {
        patientsDAO.editPatient(patientEntity);
    }

}
