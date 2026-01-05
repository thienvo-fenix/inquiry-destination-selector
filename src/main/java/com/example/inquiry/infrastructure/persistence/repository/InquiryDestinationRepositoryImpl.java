package com.example.inquiry.infrastructure.persistence.repository;

import com.example.inquiry.domain.model.InquiryDestination;
import com.example.inquiry.domain.repository.InquiryDestinationRepository;
import com.example.inquiry.infrastructure.persistence.entity.InquiryDestinationEntity;
import com.example.inquiry.infrastructure.persistence.entity.UrlEntity;
import com.example.inquiry.infrastructure.persistence.jpa.InquiryDestinationJpaRepository;
import com.example.inquiry.infrastructure.persistence.jpa.PrefectureJpaRepository;
import com.example.inquiry.infrastructure.persistence.jpa.RegionJpaRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Inquiry Destination Repository Implementation
 * 問合せ先リポジトリ実装
 */
@Repository
@RequiredArgsConstructor
public class InquiryDestinationRepositoryImpl implements InquiryDestinationRepository {
    
    private final InquiryDestinationJpaRepository inquiryDestinationJpaRepository;
    private final RegionJpaRepository regionJpaRepository;
    private final PrefectureJpaRepository prefectureJpaRepository;
    
    @Override
    public List<InquiryDestination> search(
            String inquiryDestinationName,
            String inquiryDestinationKana,
            String phoneNumber,
            String urlAddress,
            List<String> regionCodes
    ) {
        Specification<InquiryDestinationEntity> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            
            // 問合せ先名称での前方一致検索
            if (StringUtils.hasText(inquiryDestinationName)) {
                predicates.add(criteriaBuilder.like(
                        root.get("inquiryDestinationName"),
                        inquiryDestinationName + "%"
                ));
            }
            
            // 問合せ先カナでの前方一致検索
            if (StringUtils.hasText(inquiryDestinationKana)) {
                predicates.add(criteriaBuilder.like(
                        root.get("inquiryDestinationKana"),
                        inquiryDestinationKana + "%"
                ));
            }
            
            // 電話番号での前方一致検索
            if (StringUtils.hasText(phoneNumber)) {
                predicates.add(criteriaBuilder.like(
                        root.get("phoneNumber"),
                        phoneNumber + "%"
                ));
            }
            
            // 地域コードでの検索
            if (regionCodes != null && !regionCodes.isEmpty()) {
                predicates.add(root.get("regionCode").in(regionCodes));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        
        List<InquiryDestinationEntity> entities = inquiryDestinationJpaRepository.findAll(spec);
        
        // URLアドレスでの部分一致検索（後フィルタリング）
        if (StringUtils.hasText(urlAddress)) {
            entities = entities.stream()
                    .filter(entity -> entity.getUrls() != null && 
                            entity.getUrls().stream()
                                    .anyMatch(url -> url.getUrlAddress().contains(urlAddress)))
                    .collect(Collectors.toList());
        }
        
        return entities.stream()
                .map(this::convertToDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<InquiryDestination> findByCode(String inquiryDestinationCode) {
        return inquiryDestinationJpaRepository.findById(inquiryDestinationCode)
                .map(this::convertToDomain);
    }
    
    @Override
    public List<InquiryDestination> findByCodes(List<String> inquiryDestinationCodes) {
        return inquiryDestinationJpaRepository.findAllById(inquiryDestinationCodes).stream()
                .map(this::convertToDomain)
                .collect(Collectors.toList());
    }
    
    private InquiryDestination convertToDomain(InquiryDestinationEntity entity) {
        String prefectureName = prefectureJpaRepository.findById(entity.getPrefectureCode())
                .map(p -> p.getPrefectureName())
                .orElse("");
        
        String regionName = regionJpaRepository.findById(entity.getRegionCode())
                .map(r -> r.getRegionName())
                .orElse("");
        
        List<String> urlAddresses = entity.getUrls() != null
                ? entity.getUrls().stream()
                        .map(UrlEntity::getUrlAddress)
                        .collect(Collectors.toList())
                : new ArrayList<>();
        
        return InquiryDestination.builder()
                .inquiryDestinationCode(entity.getInquiryDestinationCode())
                .inquiryDestinationName(entity.getInquiryDestinationName())
                .inquiryDestinationKana(entity.getInquiryDestinationKana())
                .phoneNumber(entity.getPhoneNumber())
                .prefectureCode(entity.getPrefectureCode())
                .prefectureName(prefectureName)
                .regionCode(entity.getRegionCode())
                .regionName(regionName)
                .address(entity.getAddress())
                .urlAddresses(urlAddresses)
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
