package com.example.inquiry.infrastructure.persistence.jpa;

import com.example.inquiry.infrastructure.persistence.entity.PrefectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Prefecture JPA Repository
 * 都道府県JPAリポジトリ
 */
@Repository
public interface PrefectureJpaRepository extends JpaRepository<PrefectureEntity, String> {
    List<PrefectureEntity> findByRegionCode(String regionCode);
}
