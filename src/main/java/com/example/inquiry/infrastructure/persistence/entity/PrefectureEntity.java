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
 * Prefecture Master Entity
 * 都道府県マスタエンティティ
 */
@Entity
@Table(name = "prefecture_master")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrefectureEntity {
    
    @Id
    @Column(name = "prefecture_code", length = 10)
    private String prefectureCode;
    
    @Column(name = "prefecture_name", nullable = false, length = 50)
    private String prefectureName;
    
    @Column(name = "region_code", nullable = false, length = 10)
    private String regionCode;
    
    @Column(name = "display_order", nullable = false)
    private Integer displayOrder;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
