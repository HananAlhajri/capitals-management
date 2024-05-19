package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Base;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/03/25
 */

@Data
@Entity(name = "cap_region")
public class Region extends Base {

    @Column(unique = true)
    private String regionEn, regionAr;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;
}