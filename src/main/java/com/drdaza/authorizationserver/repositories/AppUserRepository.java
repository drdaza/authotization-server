package com.drdaza.authorizationserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drdaza.authorizationserver.models.AppUser;


@Repository
public interface AppUserRepository  extends JpaRepository<AppUser, Integer>{
    Optional<AppUser> findByUsername(String username);
}
