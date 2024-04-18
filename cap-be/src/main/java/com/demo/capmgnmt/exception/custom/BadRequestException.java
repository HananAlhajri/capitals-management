package com.demo.capmgnmt.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BadRequestException extends RuntimeException {
    private List<String> errorMessageCodes;
}