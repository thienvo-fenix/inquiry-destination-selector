package com.example.inquiry.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Region Master Domain Model
 * 地域マスタ
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    private String regionCode;
    private String regionName;
    private Integer displayOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
