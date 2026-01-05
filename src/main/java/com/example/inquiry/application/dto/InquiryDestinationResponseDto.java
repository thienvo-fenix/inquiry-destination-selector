package com.example.inquiry.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Inquiry Destination Response DTO
 * 問合せ先レスポンス
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquiryDestinationResponseDto {
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
    private String urlAddressesDisplay; // URLアドレス / 区切り表示用
}
