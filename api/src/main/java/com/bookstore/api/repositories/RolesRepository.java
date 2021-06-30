package com.bookstore.api.repositories;

import com.bookstore.api.domain.security.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Role,Long> {
}
