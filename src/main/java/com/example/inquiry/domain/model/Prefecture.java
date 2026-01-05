package com.example.inquiry.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Prefecture Master Domain Model
 * 都道府県マスタ
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prefecture {
    private String prefectureCode;
    private String prefectureName;
    private String regionCode;
    private Integer displayOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
