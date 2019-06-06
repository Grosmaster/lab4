package com.lab.springboost.repository;

import com.lab.springboost.entity.DoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends CrudRepository<DoctorEntity, Long> {
    DoctorEntity findById(Integer id);
}
