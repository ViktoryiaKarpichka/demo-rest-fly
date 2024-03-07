package com.example.demorestfly.dto;

import com.example.demorestfly.validator.PasswordMatching;
import com.example.demorestfly.validator.UserExist;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import static com.example.demorestfly.utils.Constants.PASSWORD_PATTERN;
import static com.example.demorestfly.utils.Constants.USERNAME_PATTERN;

@Getter
@Setter
@PasswordMatching
@Valid
@Schema(description = "Entity of User")
public class UserRegistrationDto {

    @NotBlank(message = "Enter username")
    @Pattern(regexp = USERNAME_PATTERN, message = "Incorrect username")
    @UserExist
    @Schema(description = "Username", example = "Anna")
    private String userName;
    @NotBlank(message = "Enter password")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Incorrect password")
    @Schema(description = "User`s password", example = "qwerty")
    private String password;
    @NotBlank(message = "Verify password")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Incorrect verify password")
    @Schema(description = "User`s verify password", example = "qwerty")
    private String verifyPassword;
}
