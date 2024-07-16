package com.demo.capmgnmt.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hanan Al-Hajri 2024/05/019
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemNotFoundException extends RuntimeException {
}