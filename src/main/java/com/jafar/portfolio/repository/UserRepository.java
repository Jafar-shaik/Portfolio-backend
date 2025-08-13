package com.jafar.portfolio.repository;

import com.jafar.portfolio.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String > {
    void deleteByUsername(String username);
    Optional<User> findByUsername(String username);
}
