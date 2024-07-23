CREATE TABLE cap_comments
(
    id          BIGINT IDENTITY PRIMARY KEY,
    comment     NVARCHAR(255) NOT NULL,
    likes_count INT    NOT NULL DEFAULT 0,
    item_id     BIGINT NOT NULL,

    created_by  BIGINT,
    created_at  DATETIME        DEFAULT CURRENT_TIMESTAMP,
    updated_by  BIGINT,
    updated_at  DATETIME        DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT FK_COMMENT_ITEM FOREIGN KEY (item_id) REFERENCES cap_master_item (id)
);

--- column stock in item
ALTER TABLE cap_master_item
    ADD stock_number INT NOT NULL DEFAULT 0
    GO

--- column likes in item
ALTER TABLE cap_master_item
    ADD likes_count INT NOT NULL DEFAULT 0
    GO