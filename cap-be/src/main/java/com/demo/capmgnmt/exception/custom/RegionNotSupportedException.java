package com.demo.capmgnmt.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hanan Al-Hajri 2024/05/19
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RegionNotSupportedException extends RuntimeException {
}
