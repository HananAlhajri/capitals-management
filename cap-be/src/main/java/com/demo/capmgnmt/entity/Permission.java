package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/03/25
 */

@Data
@Entity
@Table(name = "cap_permission")
public class Permission extends Base {

    @NotEmpty
    private String permissionEn, permissionAr;

    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;
}