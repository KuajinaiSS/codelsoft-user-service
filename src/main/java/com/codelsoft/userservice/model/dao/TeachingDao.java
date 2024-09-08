package com.codelsoft.userservice.model.dao;

import com.codelsoft.userservice.model.entity.Teaching;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeachingDao extends CrudRepository<Teaching, UUID> {
}
