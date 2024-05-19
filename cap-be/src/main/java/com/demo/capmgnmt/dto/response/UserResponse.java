package com.demo.capmgnmt.dto.response;

import lombok.Data;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

@Data
public class UserResponse {
    private String firstName, middleName, lastName, bio, title;
}