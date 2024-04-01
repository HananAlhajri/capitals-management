package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/03/25
 */

@Data
@Entity(name = "cap_role")
public class Role extends Base {

    @NotBlank
    private String roleEn, roleAr;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cap_role_permission",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<Permission> permissions;
}