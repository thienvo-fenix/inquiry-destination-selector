package com.example.inquiry.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Region Response DTO
 * 地域レスポンス
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionResponseDto {
    private String regionCode;
    private String regionName;
    private Integer displayOrder;
}
