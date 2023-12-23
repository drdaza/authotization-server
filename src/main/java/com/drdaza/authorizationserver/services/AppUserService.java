package com.drdaza.authorizationserver.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.drdaza.authorizationserver.enums.RoleName;
import com.drdaza.authorizationserver.models.AppUser;
import com.drdaza.authorizationserver.models.Role;
import com.drdaza.authorizationserver.payloads.AppUserPayload;
import com.drdaza.authorizationserver.payloads.MessageUserPayload;
import com.drdaza.authorizationserver.repositories.AppUserRepository;
import com.drdaza.authorizationserver.repositories.RoleRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class AppUserService {
    private final AppUserRepository appUserRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public MessageUserPayload createUser(AppUserPayload payload){
        AppUser appUser = AppUser.builder()
        .username(payload.username())
        .password(passwordEncoder.encode(payload.password()))
        .build();
        
        Set<Role> roles = new HashSet<>();

        payload.roles().forEach(roleItem -> {
            Role role = roleRepository.findByRole(RoleName.valueOf(roleItem)).orElseThrow(() -> new RuntimeException("role not found"));
            System.out.println("---------------------------------------------");
            System.out.println(role);
            roles.add(role);
        });

        appUser.setRoles(roles);
        appUserRepository.save(appUser);

        return new MessageUserPayload("user" + appUser.getUsername() + "added");
    }
}
