package com.jafar.portfolio.repository;

import com.jafar.portfolio.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProjectRepository extends MongoRepository< Project,String> {
    Optional<Project> findByTitle(String title);
}
