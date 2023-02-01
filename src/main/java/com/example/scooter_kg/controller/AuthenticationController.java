package com.example.scooter_kg.controller;


import com.example.scooter_kg.dto.AuthenticationRequest;
import com.example.scooter_kg.dto.AuthenticationResponse;
import com.example.scooter_kg.dto.RegisterRequest;
import com.example.scooter_kg.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest
                                                                       registerRequest){
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/auth/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest
                                                                   authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
