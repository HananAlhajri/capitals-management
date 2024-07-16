package com.demo.capmgnmt.dto.request;

import com.demo.capmgnmt.common.constraints.NonExistEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hanan Al-Hajri 2024/03/27
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NotNull
public class NewUserRequest extends BaseUserRequest {
    @Email
    @NonExistEmail
    private String email;
}