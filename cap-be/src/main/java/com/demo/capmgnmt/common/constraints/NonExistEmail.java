package com.demo.capmgnmt.common.constraints;

import com.demo.capmgnmt.repository.UserRepository;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.RequiredArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.demo.capmgnmt.common.constants.Constants.UserManagement.EMAIL_ALREADY_EXIST;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

@Constraint(validatedBy = NonExistEmail.EmailExistValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NonExistEmail {
    String message() default EMAIL_ALREADY_EXIST;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @RequiredArgsConstructor
    class EmailExistValidation implements ConstraintValidator<NonExistEmail, String> {
        private final UserRepository userRepository;

        @Override
        public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
            return email != null && !userRepository.existsByEmail(email);
        }
    }
}