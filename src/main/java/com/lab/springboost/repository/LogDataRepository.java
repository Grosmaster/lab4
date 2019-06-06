package com.lab.springboost.repository;

import com.lab.springboost.entity.LogDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface LogDataRepository  extends CrudRepository<LogDataEntity, Long> {
}