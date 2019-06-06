package com.lab.springboost.repository;

import com.lab.springboost.entity.PrescriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionsRepository  extends CrudRepository<PrescriptionEntity, Long> {
    void deleteById(Integer id);
    Integer countByDoctorByIddoctor_Id(Integer id);
}
