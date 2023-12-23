package com.drdaza.authorizationserver.payloads;

import java.util.List;

public record AppUserPayload (
     String username,
     String password,
     List<String> roles ){}
    
