DROP TABLE IF EXISTS prime_numbers;

CREATE TABLE prime_numbers(
    prime_numbers_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    prime_number INTEGER UNIQUE NOT NULL
);

INSERT INTO prime_numbers(prime_number) VALUES (2);
INSERT INTO prime_numbers(prime_number) VALUES (3);
INSERT INTO prime_numbers(prime_number) VALUES (5);
INSERT INTO prime_numbers(prime_number) VALUES (7);
INSERT INTO prime_numbers(prime_number) VALUES (11);
INSERT INTO prime_numbers(prime_number) VALUES (13);
