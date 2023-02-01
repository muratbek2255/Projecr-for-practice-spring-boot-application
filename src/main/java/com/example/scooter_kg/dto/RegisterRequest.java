package com.example.scooter_kg.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username;
    private String email;
    private String password;
}
