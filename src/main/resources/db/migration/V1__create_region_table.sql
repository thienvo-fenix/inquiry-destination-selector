-- Create Region Master Table
CREATE TABLE IF NOT EXISTS region_master (
    region_code VARCHAR(10) PRIMARY KEY COMMENT '地域コード',
    region_name VARCHAR(100) NOT NULL COMMENT '地域名称',
    display_order INT NOT NULL DEFAULT 0 COMMENT '表示順',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='地域マスタ';

-- Create Prefecture Master Table
CREATE TABLE IF NOT EXISTS prefecture_master (
    prefecture_code VARCHAR(10) PRIMARY KEY COMMENT '都道府県コード',
    prefecture_name VARCHAR(50) NOT NULL COMMENT '都道府県名',
    region_code VARCHAR(10) NOT NULL COMMENT '地域コード',
    display_order INT NOT NULL DEFAULT 0 COMMENT '表示順',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
    CONSTRAINT fk_prefecture_region FOREIGN KEY (region_code) REFERENCES region_master(region_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='都道府県マスタ';

CREATE INDEX idx_prefecture_region ON prefecture_master(region_code);
