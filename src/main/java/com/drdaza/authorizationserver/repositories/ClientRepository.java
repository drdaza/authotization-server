package com.drdaza.authorizationserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drdaza.authorizationserver.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByClientId(String clientId);
}
