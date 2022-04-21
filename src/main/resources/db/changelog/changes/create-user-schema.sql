--liquibase formatted sql

--changeset your.name:1 labels:example-label context:example-context
--comment: example comment
CREATE TABLE users (
  idUser serial PRIMARY KEY,
  name VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  gender VARCHAR(45) NULL,
  status VARCHAR(13) NULL
);
--rollback DROP TABLE students;