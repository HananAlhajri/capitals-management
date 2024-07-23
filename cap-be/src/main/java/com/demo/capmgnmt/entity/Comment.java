package com.demo.capmgnmt.entity;

import com.demo.capmgnmt.entity.base.Audit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "cap_comments")
public class Comment extends Audit {

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "likes_count", nullable = false)
    private int likes;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public void like() {
        this.likes += 1;
    }

    public void dislike() {
        this.likes -= 1;
    }
}