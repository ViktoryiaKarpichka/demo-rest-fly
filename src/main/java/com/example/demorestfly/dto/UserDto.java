package com.example.demorestfly.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Entity of User")
public class UserDto extends BaseDto {

    @Schema(description = "Username", example = "")
    private String userName;
    @Schema(description = "User`s role", example = "ROLE_USER")
    private String role;
}
