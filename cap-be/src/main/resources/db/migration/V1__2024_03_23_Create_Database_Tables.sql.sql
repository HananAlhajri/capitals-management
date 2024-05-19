--- role & permission
CREATE TABLE cap_permission
(
    id            BIGINT IDENTITY,

    permission_en NVARCHAR(50) UNIQUE NOT NULL,
    permission_ar NVARCHAR(50) UNIQUE NOT NULL,

    CONSTRAINT PK_PERMISSION PRIMARY KEY (id)
)
    GO

CREATE TABLE cap_role
(
    id      BIGINT IDENTITY,

    role_en NVARCHAR(50) UNIQUE NOT NULL,
    role_ar NVARCHAR(50) UNIQUE NOT NULL,

    CONSTRAINT PK_ROLE PRIMARY KEY (id)
)
    GO

CREATE TABLE cap_role_permission
(
    id            BIGINT IDENTITY,

    role_id       BIGINT NOT NULL REFERENCES cap_role,
    permission_id BIGINT NOT NULL REFERENCES cap_permission,

    CONSTRAINT PK_ROLE_PERMISSION PRIMARY KEY (id),
    CONSTRAINT UQ_ROLE_PERMISSION UNIQUE (role_id, permission_id)
)
    GO


---region
CREATE TABLE cap_region
(
    id        BIGINT IDENTITY,

    region_en NVARCHAR(255) NOT NULL,
    region_ar NVARCHAR(255) NOT NULL,

    CONSTRAINT PK_REGION PRIMARY KEY (id)
)
    GO

----users
CREATE TABLE cap_user
(
    id           BIGINT IDENTITY,

    first_name   NVARCHAR(50) NOT NULL,
    middle_name  NVARCHAR(50) NOT NULL,
    last_name    NVARCHAR(50) NOT NULL,
    title        NVARCHAR(50),
    bio          NVARCHAR(255),
    email        NVARCHAR(100) NOT NULL,
    password     NVARCHAR(255) NOT NULL,
    phone_number NVARCHAR(10) NOT NULL,
    address      NVARCHAR(255) NOT NULL,
    region_id    BIGINT NOT NULL REFERENCES cap_region,
    is_enabled   bit    NOT NULL DEFAULT 0,
    is_locked    bit    NOT NULL DEFAULT 0,
    image_url    NVARCHAR(255) DEFAULT 'https://cdn-icons-png.flaticon.com/512/149/149071.png',
    role_id      BIGINT NOT NULL REFERENCES cap_role,

    created_by   BIGINT,
    created_at   DATETIME        DEFAULT CURRENT_TIMESTAMP,
    updated_by   BIGINT,
    updated_at   DATETIME        DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT PK_USER PRIMARY KEY (id),
    CONSTRAINT UQ_USER_EMAIL_PHONE_NUMBER UNIQUE (email, phone_number)
)
    GO

--items & invoice
CREATE TABLE cap_master_item
(
    id          BIGINT IDENTITY,

    name        NVARCHAR(255) NOT NULL,
    description NVARCHAR(255) NOT NULL,

    CONSTRAINT PK_MASTER_ITEM PRIMARY KEY (id)
)
    GO

CREATE TABLE cap_invoice
(
    id       BIGINT IDENTITY,

    code     NVARCHAR(255) NOT NULL,
    quantity INT    NOT NULL,
    user_id  BIGINT NOT NULL REFERENCES cap_user,


    CONSTRAINT PK_INVOICE PRIMARY KEY (id)
)
    GO

CREATE TABLE cap_invoice_item
(
    id         BIGINT IDENTITY,

    item_id    BIGINT NOT NULL REFERENCES cap_master_item,
    invoice_id BIGINT NOT NULL REFERENCES cap_invoice,

    CONSTRAINT PK_INVOICE_ITEM PRIMARY KEY (id)
)
    GO