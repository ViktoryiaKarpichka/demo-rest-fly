package com.example.demorestfly.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@SecurityRequirement(name = "bearerAuth")
public class MainController {

    @GetMapping("/security")
    public String getSecurityInfo() {
        return "Security";
    }

    @GetMapping("/unsecurity")
    public String getUnSecurityInfo() {
        return "UnSecurity";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "Admin page";
    }
}