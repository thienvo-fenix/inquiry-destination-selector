package com.example.inquiry.application.usecase;

import com.example.inquiry.application.dto.RegionResponseDto;
import com.example.inquiry.domain.model.Region;
import com.example.inquiry.domain.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Get Regions Use Case
 * 地域取得ユースケース
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetRegionsUseCase {
    
    private final RegionRepository regionRepository;
    
    /**
     * Get all regions
     * 全地域を取得
     */
    public List<RegionResponseDto> execute() {
        List<Region> regions = regionRepository.findAll();
        
        return regions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    private RegionResponseDto convertToDto(Region region) {
        return RegionResponseDto.builder()
                .regionCode(region.getRegionCode())
                .regionName(region.getRegionName())
                .displayOrder(region.getDisplayOrder())
                .build();
    }
}
