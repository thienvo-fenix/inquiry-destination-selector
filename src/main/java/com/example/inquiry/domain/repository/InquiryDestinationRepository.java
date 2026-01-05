package com.example.inquiry.domain.repository;

import com.example.inquiry.domain.model.InquiryDestination;

import java.util.List;
import java.util.Optional;

/**
 * Inquiry Destination Repository Interface
 * 問合せ先リポジトリ
 */
public interface InquiryDestinationRepository {
    List<InquiryDestination> search(
            String inquiryDestinationName,
            String inquiryDestinationKana,
            String phoneNumber,
            String urlAddress,
            List<String> regionCodes
    );
    
    Optional<InquiryDestination> findByCode(String inquiryDestinationCode);
    
    List<InquiryDestination> findByCodes(List<String> inquiryDestinationCodes);
}
