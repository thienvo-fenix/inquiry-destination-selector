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
     * Get Core regions that are not deleted (用途区分=Core地域、削除されていない)
     * 表示用の地域を取得（Core地域のみ、削除フラグ=false、表示順でソート）
     */
    public List<RegionResponseDto> execute() {
        List<Region> regions = regionRepository.findCoreRegions();
        
        return regions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    /**
     * Get all active regions (not deleted)
     * 全ての有効な地域を取得（削除フラグ=false）
     */
    public List<RegionResponseDto> executeAll() {
        List<Region> regions = regionRepository.findActiveRegions();
        
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
