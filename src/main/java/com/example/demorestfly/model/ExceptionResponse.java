package com.example.demorestfly.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponse {
    @Schema(description = "Message describing the exception", example = "Some message")
    private String message;
    @Schema(description = "Exception type", example = "Some exception type")
    private String type;
}
