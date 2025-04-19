DROP TABLE IF EXISTS runs;

CREATE TABLE runs
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    title        VARCHAR(255) NOT NULL,
    miles        INT          NOT NULL,
    completed_on TIMESTAMP    NOT NULL,
    started_on   TIMESTAMP    NOT NULL,
    location     VARCHAR(255)  NOT NULL
);
