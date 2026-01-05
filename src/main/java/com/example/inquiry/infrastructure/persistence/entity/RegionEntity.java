package com.example.inquiry.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Region Master Entity
 * 地域マスタエンティティ
 */
@Entity
@Table(name = "region_master")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionEntity {
    
    @Id
    @Column(name = "region_code", length = 10)
    private String regionCode;
    
    @Column(name = "region_name", nullable = false, length = 100)
    private String regionName;
    
    @Column(name = "display_order", nullable = false)
    private Integer displayOrder;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
