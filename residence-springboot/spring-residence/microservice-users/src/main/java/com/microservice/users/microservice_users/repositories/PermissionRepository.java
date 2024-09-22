package com.microservice.users.microservice_users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.users.microservice_users.entities.PermissionEntity;

@Repository
public interface PermissionRepository extends CrudRepository<PermissionEntity, Long> {

}
