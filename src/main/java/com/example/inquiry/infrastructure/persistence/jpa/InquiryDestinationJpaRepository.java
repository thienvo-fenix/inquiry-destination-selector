package com.example.inquiry.infrastructure.persistence.jpa;

import com.example.inquiry.infrastructure.persistence.entity.InquiryDestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Inquiry Destination JPA Repository
 * 問合せ先JPAリポジトリ
 */
@Repository
public interface InquiryDestinationJpaRepository extends JpaRepository<InquiryDestinationEntity, String>, 
        JpaSpecificationExecutor<InquiryDestinationEntity> {
}
