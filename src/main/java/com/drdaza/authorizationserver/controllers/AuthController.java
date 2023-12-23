package com.drdaza.authorizationserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.authorizationserver.payloads.AppUserPayload;
import com.drdaza.authorizationserver.payloads.MessageUserPayload;
import com.drdaza.authorizationserver.services.AppUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;

    @PostMapping(path = "/create")
    public ResponseEntity<MessageUserPayload> createUser(@RequestBody AppUserPayload createUserPayload) {
        System.out.println();
        return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(createUserPayload));
    }
}
