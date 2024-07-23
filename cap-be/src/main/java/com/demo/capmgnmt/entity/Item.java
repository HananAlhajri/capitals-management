package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Base;
import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String name, description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private Double price;

    @Column(name = "likes_count", nullable = false)
    private int likes;

    @Column(name = "stock_number", nullable = false)
    private int stock;

    @ManyToMany(mappedBy = "items")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public void like() {
        this.likes += 1;
    }

    public void dislike() {
        this.likes -= 1;
    }
}