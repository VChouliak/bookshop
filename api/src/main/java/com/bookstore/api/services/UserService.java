package com.bookstore.api.services;

import com.bookstore.api.domain.security.entities.User;
import com.bookstore.api.domain.security.entities.UserRole;

import java.util.Set;

public interface UserService {
    User createUser(User user, Set<UserRole> userRoles);
}
