package com.segurity.spring_segurity.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.segurity.spring_segurity.entities.UserEntity;
import com.segurity.spring_segurity.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; 

    public List<UserEntity> getUsers(){


        return (List<UserEntity>) userRepository.findAll();
    }

    public UserEntity createUser(UserEntity userRequest){

        return userRepository.save(userRequest);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        try {
            
            UserEntity userEntity = userRepository.findUserEntityByUsername(username)
                                        .orElseThrow(()-> new UsernameNotFoundException("El usuario " + username + " no existe en la DB"));
            
            List<SimpleGrantedAuthority> authorityList =  new ArrayList<>();
    
            authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(userEntity.getRole().getName())));

            userEntity.getRole().getPermissions().stream()
            .forEach(permissions -> authorityList.add(new SimpleGrantedAuthority(permissions.getName())));
    
    
            return new User(userEntity.getUsername(),
             userEntity.getPassword(),
             userEntity.isEnabled(),
             userEntity.isAccountNoExpired(),
             userEntity.isCredentialNoExpired(),
             userEntity.isAccountNoLocked(),
             authorityList);

        } catch (Exception e) {
            
            System.out.println("ERROR: " + e);
            return null;
        }

    }
}
