package com.bookstore.api;

import com.bookstore.api.config.SecurityUtility;
import com.bookstore.api.domain.security.entities.Role;
import com.bookstore.api.domain.security.entities.User;
import com.bookstore.api.domain.security.entities.UserRole;
import com.bookstore.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("John");;
        user1.setLastName("Doe");
        user1.setUsername("john");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("doe"));
        user1.setEmail("john@doe.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1,role1));
        userService.createUser(user1, userRoles);

        userRoles.clear();

        User user2 = new User();
        user2.setFirstName("Admin");;
        user2.setLastName("Administrator");
        user2.setUsername("admin");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
        user2.setEmail("admin@administrator.com");
        Role role2 = new Role();
        role2.setRoleId(0);
        role2.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user2,role2));
        userService.createUser(user2, userRoles);



    }
}
