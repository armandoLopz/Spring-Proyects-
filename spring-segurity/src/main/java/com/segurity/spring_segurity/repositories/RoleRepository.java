package com.segurity.spring_segurity.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.segurity.spring_segurity.entities.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity,UUID> {
    
}