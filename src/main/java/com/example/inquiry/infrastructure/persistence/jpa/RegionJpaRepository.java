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
}
