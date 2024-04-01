package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Hanan Al-Hajri 2024/03/25
 */

@Data
@Entity
@Table(name = "cap_address")
public class Address extends Audit {
    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @NotBlank
    private String city;

    @NotBlank
    @Column(name = "street_name")
    private String streetName;

    @Digits(integer = 10, fraction = 0, message = "Postal number should only contain digits")
    private String postalNumber;
}