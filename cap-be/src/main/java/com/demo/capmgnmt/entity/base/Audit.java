package com.demo.capmgnmt.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

/**
 * @author Hanan Al-Hajri 2024/03/24
 */

@Data
@MappedSuperclass
public abstract class Audit extends Base {
    @CreatedBy
    @Column(nullable = false)
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;

    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;
}