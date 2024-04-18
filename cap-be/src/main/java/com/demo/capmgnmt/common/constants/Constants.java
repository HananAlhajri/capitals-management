package com.demo.capmgnmt.common.constants;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

public interface Constants {
    interface Common {

    }

    interface UserManagement {
        int MIN_NAME_LENGTH = 2;
        int MAX_NAME_LENGTH = 20;
        String PHONE_NUMBER_REGEX = "05\\d{8}";
        String INVALID_NAME_LENGTH = "Name length must be between 2-20";
        String EMAIL_ALREADY_EXIST = "The email you entered is already registered";
        String INVALID_PHONE_NUMBER = "Phone number must be 10 digits and starts with 05";
    }
}