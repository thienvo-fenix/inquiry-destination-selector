package com.example.inquiry.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Inquiry Destination Search Request DTO
 * 問合せ先検索リクエスト
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquirySearchRequestDto {
    private String inquiryDestinationName;
    private String inquiryDestinationKana;
    private String phoneNumber;
    private String urlAddress;
    private List<String> regionCodes;
}
