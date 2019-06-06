package com.lab.springboost.Controller;

import com.lab.springboost.Controller.wrapperxsl.DoctorXSL;
import com.lab.springboost.entity.DoctorEntity;
import com.lab.springboost.model.DoctorsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorsDAO doctorsDAO;

    @GetMapping(produces = { APPLICATION_JSON_VALUE,
            APPLICATION_XML_VALUE})
    public Object doctors()  {
        return  new DoctorXSL(doctorsDAO.allDoctors());
    }

    @GetMapping(value = "{id}", produces = { APPLICATION_JSON_VALUE,
            APPLICATION_XML_VALUE})
    public Object findById(@PathVariable int id) {
        return  doctorsDAO.findById(id);
    }

    @DeleteMapping("{id}")
    public void removeDoctor(@PathVariable int id) {
        doctorsDAO.removeDoctor(doctorsDAO.findById(id));
    }

    @PostMapping
    public void createDoctor(@RequestBody DoctorEntity doctorEntity) {
        doctorsDAO.addDoctor(doctorEntity);
    }

    @PutMapping
    public void editDoctor(@RequestBody DoctorEntity doctorEntity) {
        doctorsDAO.editDoctor(doctorEntity);
    }

}
