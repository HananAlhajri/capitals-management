package com.demo.capmgnmt.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Hanan Al-Hajri 2024/03/27
 */

@Data
@NotNull
public class UpdateUserRequest extends BaseUserRequest {
    @Email
    private String email;
}