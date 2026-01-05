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
 * URL Master Entity
 * URLマスタエンティティ
 */
@Entity
@Table(name = "url_master")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private Long urlId;
    
    @Column(name = "inquiry_destination_code", nullable = false, length = 20)
    private String inquiryDestinationCode;
    
    @Column(name = "url_address", nullable = false, length = 256)
    private String urlAddress;
    
    @Column(name = "display_order", nullable = false)
    private Integer displayOrder;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
