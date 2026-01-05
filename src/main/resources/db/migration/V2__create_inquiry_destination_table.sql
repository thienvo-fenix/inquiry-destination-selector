-- Create Inquiry Destination Master Table
CREATE TABLE IF NOT EXISTS inquiry_destination_master (
    inquiry_destination_code VARCHAR(20) PRIMARY KEY COMMENT '問合せ先コード',
    inquiry_destination_name VARCHAR(100) NOT NULL COMMENT '問合せ先名称',
    inquiry_destination_kana VARCHAR(200) NOT NULL COMMENT '問合せ先カナ',
    phone_number VARCHAR(13) COMMENT '電話番号',
    prefecture_code VARCHAR(10) NOT NULL COMMENT '都道府県コード',
    region_code VARCHAR(10) NOT NULL COMMENT '地域コード',
    address VARCHAR(500) COMMENT '住所',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
    CONSTRAINT fk_inquiry_prefecture FOREIGN KEY (prefecture_code) REFERENCES prefecture_master(prefecture_code),
    CONSTRAINT fk_inquiry_region FOREIGN KEY (region_code) REFERENCES region_master(region_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='問合せ先マスタ';

-- Create URL Master Table
CREATE TABLE IF NOT EXISTS url_master (
    url_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'URL ID',
    inquiry_destination_code VARCHAR(20) NOT NULL COMMENT '問合せ先コード',
    url_address VARCHAR(256) NOT NULL COMMENT 'URLアドレス',
    display_order INT NOT NULL DEFAULT 0 COMMENT '表示順',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
    CONSTRAINT fk_url_inquiry FOREIGN KEY (inquiry_destination_code) REFERENCES inquiry_destination_master(inquiry_destination_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='URLマスタ';

-- Create Indexes
CREATE INDEX idx_inquiry_name ON inquiry_destination_master(inquiry_destination_name);
CREATE INDEX idx_inquiry_kana ON inquiry_destination_master(inquiry_destination_kana);
CREATE INDEX idx_inquiry_phone ON inquiry_destination_master(phone_number);
CREATE INDEX idx_inquiry_region ON inquiry_destination_master(region_code);
CREATE INDEX idx_url_inquiry_code ON url_master(inquiry_destination_code);
CREATE INDEX idx_url_address ON url_master(url_address);
