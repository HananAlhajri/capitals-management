package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Audit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/03/25
 */

@Data
@Entity(name = "cap_region")
public class Region extends Audit {

    @NotBlank
    private String regionEn, regionAr;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Address> addresses;

}