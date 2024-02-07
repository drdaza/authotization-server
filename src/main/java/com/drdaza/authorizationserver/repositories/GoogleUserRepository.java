package com.drdaza.authorizationserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drdaza.authorizationserver.models.GoogleUser;

@Repository
public interface GoogleUserRepository extends JpaRepository<GoogleUser, Integer>{
    Optional<GoogleUser> findByEmail(String email);
}
