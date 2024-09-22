package com.microservice.users.microservice_users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.users.microservice_users.entities.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

}
