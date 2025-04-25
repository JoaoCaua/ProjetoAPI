package com.projeto2025.fatec.ProjetoAPI.security;

import jakarta.validation.constraints.NotBlank;

public class LoginDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public @NotBlank String getUsername() {
        return username;
    }

    public @NotBlank String getPassword() {
        return password;
    }
}
