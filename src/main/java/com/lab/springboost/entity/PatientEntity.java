package com.lab.springboost.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patient", schema = "public")
public class PatientEntity {
    private Integer id;
    private String firstname;
    private String fathername;
    private String lastname;
    private String phone;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "fathername")
    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(fathername, that.fathername) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, fathername, lastname, phone);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getClass().getName()).append(' ')
                .append(id).append(' ')
                .append(firstname).append(' ')
                .append(fathername).append(' ')
                .append(lastname).toString();
    }
}
