DROP TABLE user IF EXISTS;

CREATE TABLE username (
id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
user_name VARCHAR(255) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL
);
