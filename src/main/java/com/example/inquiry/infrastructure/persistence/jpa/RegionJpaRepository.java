package com.example.inquiry.infrastructure.persistence.jpa;

import com.example.inquiry.infrastructure.persistence.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Region JPA Repository
 * 地域JPAリポジトリ
 */
@Repository
public interface RegionJpaRepository extends JpaRepository<RegionEntity, String> {
    List<RegionEntity> findAllByOrderByDisplayOrderAsc();
    
    /**
     * Find regions by usage classification and not deleted, ordered by display order
     * 用途区分でフィルタし、削除されていない地域を表示順で取得
     */
    List<RegionEntity> findByUsageClassificationAndIsDeletedFalseOrderByDisplayOrderAsc(String usageClassification);
    
    /**
     * Find all active regions (not deleted), ordered by display order
     * 削除されていない全ての地域を表示順で取得
     */
    List<RegionEntity> findByIsDeletedFalseOrderByDisplayOrderAsc();
}
