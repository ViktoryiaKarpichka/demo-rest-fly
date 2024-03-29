package com.example.demorestfly.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ErrorValidationResponse extends BaseResponse {

    @Schema(description = "List of validation errors", type = "array", example = "[\"The 'name' field is required\", \"Some validation error\"]")
    private List<String> errors;
    @Schema(description = "Exception type", example = "Some validation exception")
    private String message;

    public ErrorValidationResponse(HttpStatus status, List<String> errors, String message) {
        super(status.value());
        this.errors = errors;
        this.message = message;
    }
}
