CREATE TABLE movements
(
    id            SERIAL PRIMARY KEY,
    type_movement VARCHAR(20) CHECK (type_movement in ('DEPOSIT', 'WITHDRAWAL')) NOT NULL,
    amount        DECIMAL                                                        NOT NULL,
    account_id    INTEGER                                                        NOT NULL,
    created_at    TIMESTAMP DEFAULT now()                                        NOT NULL
);

CREATE TABLE movements_audit
(
    id            SERIAL PRIMARY KEY,
    type_movement VARCHAR(20) CHECK (type_movement in ('DEPOSIT', 'WITHDRAWAL')) NOT NULL,
    amount        DECIMAL                 NOT NULL,
    account_id    INTEGER                 NOT NULL,
    status        VARCHAR(20) CHECK (status in ('CREATED', 'PROCESSED', 'REJECTED')) NOT NULL,
    detail        VARCHAR,
    created_at    TIMESTAMP DEFAULT now() NOT NULL,
    updated_at    TIMESTAMP
);