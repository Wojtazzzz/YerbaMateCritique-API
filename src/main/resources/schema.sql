CREATE TABLE IF NOT EXISTS yerba (
    id          VARCHAR(60)  DEFAULT RANDOM_UUID()  PRIMARY KEY,
    name        VARCHAR      NOT NULL,
    producer    VARCHAR      NOT NULL,
    flavour     VARCHAR      NOT NULL
);