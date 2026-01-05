package com.example.inquiry.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Inquiry Destination Master Entity
 * 問合せ先マスタエンティティ
 */
@Entity
@Table(name = "inquiry_destination_master")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquiryDestinationEntity {
    
    @Id
    @Column(name = "inquiry_destination_code", length = 20)
    private String inquiryDestinationCode;
    
    @Column(name = "inquiry_destination_name", nullable = false, length = 100)
    private String inquiryDestinationName;
    
    @Column(name = "inquiry_destination_kana", nullable = false, length = 200)
    private String inquiryDestinationKana;
    
    @Column(name = "phone_number", length = 13)
    private String phoneNumber;
    
    @Column(name = "prefecture_code", nullable = false, length = 10)
    private String prefectureCode;
    
    @Column(name = "region_code", nullable = false, length = 10)
    private String regionCode;
    
    @Column(name = "address", length = 500)
    private String address;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "inquiryDestinationCode", fetch = FetchType.LAZY)
    @OrderBy("displayOrder ASC")
    private List<UrlEntity> urls;
}
