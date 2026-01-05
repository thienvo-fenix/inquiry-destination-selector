package com.example.inquiry.application.usecase;

import com.example.inquiry.application.dto.InquiryDestinationResponseDto;
import com.example.inquiry.application.dto.InquirySearchRequestDto;
import com.example.inquiry.application.dto.InquirySearchResponseDto;
import com.example.inquiry.domain.model.InquiryDestination;
import com.example.inquiry.domain.repository.InquiryDestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Search Inquiry Destinations Use Case
 * 問合せ先検索ユースケース
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchInquiryDestinationsUseCase {
    
    private final InquiryDestinationRepository inquiryDestinationRepository;
    
    /**
     * Search inquiry destinations
     * 問合せ先を検索
     */
    public InquirySearchResponseDto execute(InquirySearchRequestDto request) {
        List<InquiryDestination> destinations = inquiryDestinationRepository.search(
                request.getInquiryDestinationName(),
                request.getInquiryDestinationKana(),
                request.getPhoneNumber(),
                request.getUrlAddress(),
                request.getRegionCodes()
        );
        
        List<InquiryDestinationResponseDto> responseDtos = destinations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        
        return InquirySearchResponseDto.builder()
                .totalCount(responseDtos.size())
                .inquiryDestinations(responseDtos)
                .build();
    }
    
    private InquiryDestinationResponseDto convertToDto(InquiryDestination destination) {
        String urlDisplay = destination.getUrlAddresses() != null 
                ? String.join(" / ", destination.getUrlAddresses())
                : "";
        
        return InquiryDestinationResponseDto.builder()
                .inquiryDestinationCode(destination.getInquiryDestinationCode())
                .inquiryDestinationName(destination.getInquiryDestinationName())
                .inquiryDestinationKana(destination.getInquiryDestinationKana())
                .phoneNumber(destination.getPhoneNumber())
                .prefectureCode(destination.getPrefectureCode())
                .prefectureName(destination.getPrefectureName())
                .regionCode(destination.getRegionCode())
                .regionName(destination.getRegionName())
                .address(destination.getAddress())
                .urlAddresses(destination.getUrlAddresses())
                .urlAddressesDisplay(urlDisplay)
                .build();
    }
}
