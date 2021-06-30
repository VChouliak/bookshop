package com.bookstore.api.domain.security.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int roleId;
    private String name;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    public Role() {

    }

    public Role(int roleId, String name, Set<UserRole> userRoleSet) {
        this.roleId = roleId;
        this.name = name;
        this.userRoles = userRoleSet;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoles;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoles = userRoleSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId == role.roleId && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name);
    }
}
