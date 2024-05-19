package com.demo.capmgnmt.common.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Hanan Al-Hajri 2024/04/18
 */

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum RoleEnum {
    ADMIN(1L),
    USER(2L);

    long id;
}