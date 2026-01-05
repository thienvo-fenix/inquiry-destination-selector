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
}
