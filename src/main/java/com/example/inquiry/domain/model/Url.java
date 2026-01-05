package com.example.inquiry.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * URL Master Domain Model
 * URLマスタ
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Url {
    private Long urlId;
    private String inquiryDestinationCode;
    private String urlAddress;
    private Integer displayOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
