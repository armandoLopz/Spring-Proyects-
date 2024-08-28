package com.segurity.spring_segurity.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.segurity.spring_segurity.entities.UserEntity;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, UUID>{

    Optional<UserEntity> findUserEntityByUsername(String username); 

}
