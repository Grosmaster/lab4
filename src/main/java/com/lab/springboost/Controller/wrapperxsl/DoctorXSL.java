package com.lab.springboost.Controller.wrapperxsl;

import com.lab.springboost.entity.DoctorEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "doctor")
public class DoctorXSL {
    private List<DoctorEntity> doctors;

    public DoctorXSL(List<DoctorEntity> doctors) {
        this.doctors = doctors;
    }
    @XmlElement(name = "doc")
    public List<DoctorEntity> getDoctors() {
        return doctors;
    }
}
