package com.jafar.portfolio.repository;

import com.jafar.portfolio.entity.ConfigApiEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigApiEntityRepository extends MongoRepository<ConfigApiEntity , String > {
}
