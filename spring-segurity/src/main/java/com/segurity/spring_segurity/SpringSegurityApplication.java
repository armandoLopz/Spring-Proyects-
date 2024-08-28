package com.segurity.spring_segurity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.segurity.spring_segurity.entities.PermissionEntity;
import com.segurity.spring_segurity.entities.RoleEntity;
import com.segurity.spring_segurity.entities.UserEntity;
import com.segurity.spring_segurity.repositories.UserRepository;

@SpringBootApplication
public class SpringSegurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSegurityApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner init(UserRepository userRepository){

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		
		return args ->{

			PermissionEntity createPermission = PermissionEntity.builder()
			.name("CREATE")
			.build();

			PermissionEntity readPermission = PermissionEntity.builder()
			.name("READ")
			.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
			.name("UPDATE")
			.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
			.name("DELETE")
			.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
			.name("REFACTOR")
			.build();

			RoleEntity adminRole = RoleEntity.builder()
			.name("ADMIN")
			.UserEntitySet(new HashSet<UserEntity>())
			.permissions(Set.of(
				createPermission,
				readPermission,
				updatePermission,
				deletePermission))
			.build();

			RoleEntity devRole = RoleEntity.builder()
			.name("DEV")
			.UserEntitySet(new HashSet<UserEntity>())
			.permissions(Set.of(
				createPermission,
				readPermission,
				updatePermission,
				refactorPermission,
				deletePermission))
			.build();

			RoleEntity userRole = RoleEntity.builder()
			.name("USER")
			.UserEntitySet(new HashSet<UserEntity>())
			.permissions(Set.of(readPermission, createPermission))
			.build();
			
			RoleEntity invitedRole = RoleEntity.builder()
			.name("INVITE")
			.UserEntitySet(new HashSet<UserEntity>())
			.permissions(Set.of(readPermission, createPermission))
			.build();

			UserEntity user1 = UserEntity.builder()
			.username("arm")
			.password(bcrypt.encode("1235333"))
			.role(invitedRole)
			.accountNoExpired(true)
			.accountNoLocked(true)
			.credentialNoExpired(true)
			.isEnabled(true)
			.build();

			UserEntity user2 = UserEntity.builder()
			.username("ale")
			.password(bcrypt.encode("abcaaa"))
			.role(adminRole)
			.accountNoExpired(true)
			.accountNoLocked(true)
			.credentialNoExpired(true)
			.isEnabled(true)
			.build();

			UserEntity user3 = UserEntity.builder()
			.username("user")
			.password(bcrypt.encode("1loaaa"))
			.role(devRole)
			.accountNoExpired(true)
			.accountNoLocked(true)
			.credentialNoExpired(true)
			.isEnabled(true)
			.build();

			UserEntity user4 = UserEntity.builder()
			.username("marj")
			.password(bcrypt.encode("1235aa"))
			.role(userRole)
			.accountNoExpired(true)
			.accountNoLocked(true)
			.credentialNoExpired(true)
			.isEnabled(true)
			.build();

			userRepository.saveAll(Set.of(user1,user2,user3,user4));
		};
	}

}
