-- Add usage_classification and is_deleted columns to region_master
ALTER TABLE region_master 
ADD COLUMN usage_classification VARCHAR(20) NOT NULL DEFAULT 'CORE' COMMENT '用途区分 (CORE: Core地域, OTHER: その他)',
ADD COLUMN is_deleted BOOLEAN NOT NULL DEFAULT FALSE COMMENT '削除フラグ';

-- Update existing data - set all current regions as CORE (except overseas which is OTHER)
UPDATE region_master SET usage_classification = 'CORE' WHERE region_code != '99';
UPDATE region_master SET usage_classification = 'OTHER' WHERE region_code = '99';

-- Create index for filtering
CREATE INDEX idx_region_usage ON region_master(usage_classification, is_deleted, display_order);
