--- category table & relation with item
CREATE TABLE cap_master_category
(
    id            BIGINT IDENTITY,

    category_en NVARCHAR(50) UNIQUE NOT NULL,
    category_ar NVARCHAR(50) UNIQUE NOT NULL,

    CONSTRAINT PK_CATEGORY PRIMARY KEY (id)
)
    GO

ALTER TABLE cap_master_item
ADD category_id BIGINT NOT NULL REFERENCES cap_master_category
GO

--- column price in item
ALTER TABLE cap_master_item
ADD price DECIMAL(10, 2) NOT NULL
GO