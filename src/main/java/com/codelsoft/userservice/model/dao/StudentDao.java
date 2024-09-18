package com.codelsoft.userservice.model.dao;

import com.codelsoft.userservice.model.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentDao extends CrudRepository<Student, UUID> {
    Optional<Student> findByEmail(String email);
}


