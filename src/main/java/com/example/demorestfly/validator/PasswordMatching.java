package com.example.demorestfly.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.example.demorestfly.utils.Constants.PASSWORDS_MATCHING;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordMatchingValidator.class)
@Target(TYPE)
@Retention(RUNTIME)
public @interface PasswordMatching {

    String message() default PASSWORDS_MATCHING;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
