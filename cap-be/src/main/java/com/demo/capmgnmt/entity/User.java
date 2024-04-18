package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/03/24
 */

@Data
@Entity
@Table(name = "cap_user")
public class User extends Audit {

    @NotBlank
    private String firstName, middleName, lastName;

    private String title, bio;

    @Email
    private String email;

    private String password;

    @Digits(integer = 10, fraction = 0, message = "Phone number should only contain digits")
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "region_id")
    private Region region;

    private String address;

    private boolean isEnabled, isLocked;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Invoice> invoices;
}