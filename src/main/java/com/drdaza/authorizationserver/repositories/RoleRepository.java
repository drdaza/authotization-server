package com.drdaza.authorizationserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drdaza.authorizationserver.enums.RoleName;
import com.drdaza.authorizationserver.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRole (RoleName roleName);
}
