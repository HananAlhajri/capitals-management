package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/03/25
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "cap_master_item")
public class Item extends Base {

    @NotBlank
    private String name, description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private Double price;

    @ManyToMany(mappedBy = "items")
    private List<Invoice> invoices;
}