package com.example.scooter_kg.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
}