package com.example.inquiry.infrastructure.persistence.jpa;

import com.example.inquiry.infrastructure.persistence.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * URL JPA Repository
 * URL JPAリポジトリ
 */
@Repository
public interface UrlJpaRepository extends JpaRepository<UrlEntity, Long> {
    List<UrlEntity> findByInquiryDestinationCodeOrderByDisplayOrderAsc(String inquiryDestinationCode);
}
