package com.example.demorestfly.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Entity of User")
public class JwtRequest {

    @NotBlank(message = "Enter username")
    @Schema(description = "Username", example = "Anna")
    private String username;
    @NotBlank(message = "Enter password")
    @Schema(description = "User`s password", example = "qwerty")
    private String password;
}
