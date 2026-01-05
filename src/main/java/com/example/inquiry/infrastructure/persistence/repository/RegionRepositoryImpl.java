package com.example.inquiry.infrastructure.persistence.repository;

import com.example.inquiry.domain.model.Region;
import com.example.inquiry.domain.repository.RegionRepository;
import com.example.inquiry.infrastructure.persistence.entity.RegionEntity;
import com.example.inquiry.infrastructure.persistence.jpa.RegionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Region Repository Implementation
 * 地域リポジトリ実装
 */
@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepository {
    
    private final RegionJpaRepository regionJpaRepository;
    
    @Override
    public List<Region> findAll() {
        return regionJpaRepository.findAllByOrderByDisplayOrderAsc().stream()
                .map(this::convertToDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<Region> findByCode(String regionCode) {
        return regionJpaRepository.findById(regionCode)
                .map(this::convertToDomain);
    }
    
    private Region convertToDomain(RegionEntity entity) {
        return Region.builder()
                .regionCode(entity.getRegionCode())
                .regionName(entity.getRegionName())
                .displayOrder(entity.getDisplayOrder())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
