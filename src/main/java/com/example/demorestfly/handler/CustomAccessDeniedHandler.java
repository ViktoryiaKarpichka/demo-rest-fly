package com.example.demorestfly.handler;

import com.example.demorestfly.exception.CustomExceptionHandler;
import com.example.demorestfly.model.BaseResponse;
import com.example.demorestfly.model.ExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.example.demorestfly.utils.ResponseUtils.getObjectMapperWithTimeModule;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final CustomExceptionHandler customExceptionHandler;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws ServletException, IOException {
        ResponseEntity<BaseResponse> responseEntity = customExceptionHandler.handleException(ex);
        ExceptionResponse responseEntityBody = (ExceptionResponse) responseEntity.getBody();
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(responseEntity.getStatusCode().value());
        ObjectMapper mapper = getObjectMapperWithTimeModule();
        response.getWriter().write(mapper.writeValueAsString(responseEntityBody));
    }
}
