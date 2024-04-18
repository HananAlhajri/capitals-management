package com.demo.capmgnmt.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static com.demo.capmgnmt.common.constants.Constants.UserManagement.*;

/**
 * @author Hanan Al-Hajri 2024/03/27
 */

@Data
@NotNull
public class BaseUserRequest {

    @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH, message = INVALID_NAME_LENGTH)
    private String firstName, middleName, lastName;

    private String password;

    private String bio;

    @Pattern(regexp = PHONE_NUMBER_REGEX, message = INVALID_PHONE_NUMBER)
    private String phoneNumber;

    private Long regionId;

    private String address;
}