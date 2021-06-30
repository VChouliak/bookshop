package com.bookstore.api.services.impl;

import com.bookstore.api.domain.security.entities.User;
import com.bookstore.api.domain.security.entities.UserRole;
import com.bookstore.api.repositories.RolesRepository;
import com.bookstore.api.repositories.UserRepository;
import com.bookstore.api.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;
    private RolesRepository rolesRepository;

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    public UserServiceImplementation(UserRepository userRepository, RolesRepository rolesRepository) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null){
            LOG.info("User {} allready exists...", user.getUsername());
        }else {
            for (UserRole ur : userRoles){
                rolesRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }
        return localUser;
    }
}
