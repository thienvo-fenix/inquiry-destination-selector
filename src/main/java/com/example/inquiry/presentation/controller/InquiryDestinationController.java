package com.example.inquiry.presentation.controller;

import com.example.inquiry.application.dto.InquirySearchRequestDto;
import com.example.inquiry.application.dto.InquirySearchResponseDto;
import com.example.inquiry.application.dto.RegionResponseDto;
import com.example.inquiry.application.usecase.GetRegionsUseCase;
import com.example.inquiry.application.usecase.SearchInquiryDestinationsUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Inquiry Destination Controller
 * 問合せ先コントローラー
 */
@RestController
@RequestMapping("/api/inquiry-destinations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InquiryDestinationController {
    
    private final SearchInquiryDestinationsUseCase searchInquiryDestinationsUseCase;
    private final GetRegionsUseCase getRegionsUseCase;
    
    /**
     * Get all regions (all active regions including overseas)
     * 地域一覧取得（海外を含む全ての有効な地域）
     * 
     * @return List of regions
     */
    @GetMapping("/regions")
    public ResponseEntity<List<RegionResponseDto>> getRegions() {
        List<RegionResponseDto> regions = getRegionsUseCase.executeAll();
        return ResponseEntity.ok(regions);
    }
    
    /**
     * Search inquiry destinations
     * 問合せ先検索
     * 
     * @param request Search conditions
     * @return Search results
     */
    @PostMapping("/search")
    public ResponseEntity<InquirySearchResponseDto> searchInquiryDestinations(
            @Valid @RequestBody InquirySearchRequestDto request
    ) {
        InquirySearchResponseDto response = searchInquiryDestinationsUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
    
    /**
     * Get inquiry destinations (GET version for simple searches)
     * 問合せ先検索（GETバージョン）
     * 
     * @param inquiryDestinationName Inquiry destination name
     * @param inquiryDestinationKana Inquiry destination kana
     * @param phoneNumber Phone number
     * @param urlAddress URL address
     * @param regionCodes Region codes (comma separated)
     * @return Search results
     */
    @GetMapping
    public ResponseEntity<InquirySearchResponseDto> getInquiryDestinations(
            @RequestParam(required = false) String inquiryDestinationName,
            @RequestParam(required = false) String inquiryDestinationKana,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String urlAddress,
            @RequestParam(required = false) List<String> regionCodes
    ) {
        InquirySearchRequestDto request = InquirySearchRequestDto.builder()
                .inquiryDestinationName(inquiryDestinationName)
                .inquiryDestinationKana(inquiryDestinationKana)
                .phoneNumber(phoneNumber)
                .urlAddress(urlAddress)
                .regionCodes(regionCodes)
                .build();
        
        InquirySearchResponseDto response = searchInquiryDestinationsUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
