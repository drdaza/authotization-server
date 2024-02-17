package com.drdaza.authorizationserver.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.authorizationserver.payloads.CreateClientPayload;
import com.drdaza.authorizationserver.payloads.MessageUserPayload;
import com.drdaza.authorizationserver.services.ClientService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {


    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<MessageUserPayload> create(@RequestBody CreateClientPayload client) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(client));
    }
    
}
