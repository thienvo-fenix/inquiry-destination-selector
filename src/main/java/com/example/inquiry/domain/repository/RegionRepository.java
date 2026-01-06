package com.example.inquiry.domain.repository;

import com.example.inquiry.domain.model.Region;

import java.util.List;
import java.util.Optional;

/**
 * Region Repository Interface
 * 地域リポジトリ
 */
public interface RegionRepository {
    List<Region> findAll();
    Optional<Region> findByCode(String regionCode);
    
    /**
     * Find Core regions that are not deleted, ordered by display order
     * Core地域で削除されていない地域を表示順で取得
     */
    List<Region> findCoreRegions();
    
    /**
     * Find all active regions (not deleted), ordered by display order
     * 削除されていない全ての地域を表示順で取得
     */
    List<Region> findActiveRegions();
}
