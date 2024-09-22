package com.microservice.users.microservice_users.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@Entity
public class UsersEntity {

    // THE ID is reference the Cedula
    @Id
    private Long id;

    @Column(unique = true)
    private String username;

    private String name;

    private String lastname;

    private String email;

    private String password;

    private boolean isMoroso;
    
    @OneToMany
    private Set<RoleEntity> role;

    //Atributtes required for spring security 

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "account_No_Expired")
    private boolean accountNoExpired;

    @Column(name = "account_No_Locked")
    private boolean accountNoLocked;

    @Column(name = "credential_No_Expired")
    private boolean credentialNoExpired;

}
