package com.lab.springboost.Controller;

import com.lab.springboost.entity.DoctorEntity;
import com.lab.springboost.entity.PrescriptionEntity;
import com.lab.springboost.model.DoctorsDAO;
import com.lab.springboost.model.PrescriptionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @GetMapping(produces = { APPLICATION_JSON_VALUE,
            APPLICATION_XML_VALUE })
    public Object allPrescription()  {
        return  prescriptionDAO.allPrescription();
    }

    @GetMapping(value = "{id}", produces = { APPLICATION_JSON_VALUE,
            APPLICATION_XML_VALUE })
    public Object findById(@PathVariable int id) {
        return  prescriptionDAO.findById(id);
    }

    @DeleteMapping("{id}")
    public void removePrescription(@PathVariable int id) {
        prescriptionDAO.removePrescription(prescriptionDAO.findById(id));
    }

    @PostMapping
    public void createPrescription(@RequestBody PrescriptionEntity prescriptionEntity) {
        prescriptionDAO.addPrescription(prescriptionEntity);
    }

    @PutMapping
    public void editPrescription(@RequestBody PrescriptionEntity prescriptionEntity) {
        prescriptionDAO.editPrescription(prescriptionEntity);
    }

}
