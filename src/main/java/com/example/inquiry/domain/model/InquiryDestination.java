package com.example.inquiry.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Inquiry Destination Domain Model
 * 問合せ先マスタ
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquiryDestination {
    private String inquiryDestinationCode;
    private String inquiryDestinationName;
    private String inquiryDestinationKana;
    private String phoneNumber;
    private String prefectureCode;
    private String prefectureName;
    private String regionCode;
    private String regionName;
    private String address;
    private List<String> urlAddresses;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
