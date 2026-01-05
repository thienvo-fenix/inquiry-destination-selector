package com.example.inquiry.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JPA Configuration
 * JPA設定
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.example.inquiry.infrastructure.persistence.jpa")
public class JpaConfig {
}
