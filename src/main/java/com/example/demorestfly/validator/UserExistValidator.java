package com.example.demorestfly.validator;

import com.example.demorestfly.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<UserExist, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.isUserExist(name);
    }
}
