package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/03/25
 */

@Data
@Entity
@Table(name = "cap_master_item")
public class Item extends Base {

    @NotBlank
    private String name, description;

    @ManyToMany(mappedBy = "items")
    private List<Invoice> invoices;
}