CREATE TABLE runs
(
    id           SERIAL PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    miles        INT          NOT NULL,
    completed_on TIMESTAMP    NOT NULL,
    started_on   TIMESTAMP    NOT NULL,
    location_id  VARCHAR(50)  NOT NULL
);
