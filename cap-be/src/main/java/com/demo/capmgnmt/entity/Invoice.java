package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/03/25
 */

@Data
@Entity
@Table(name = "cap_invoice")
public class Invoice extends Base {

    @NotBlank
    private String code;

    @NotNull
    private int quantity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cap_invoice_item",
            joinColumns = @JoinColumn(name = "invoice_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}