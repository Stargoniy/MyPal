CREATE DATABASE mypal CHARACTER SET latin1 COLLATE latin1_swedish_ci;

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    active tinyint(1),
    system tinyint(1)
) ENGINE=innodb;

CREATE TABLE transactions(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    debit_id INT,
    credit_id INT,
    sum DOUBLE,
    status tinyint(1)
) ENGINE=innodb;

INSERT INTO users VALUES(1,'Vasya','Germanov','admin@gmail.com','81dc9bdb52d04dc2036dbd8313ed055',1,1);
INSERT INTO users VALUES(2,'Alex','Vasnecov','alex@gmail.com','81dc9bdb52d04dc2036dbd8313ed055',1,1);
INSERT INTO users VALUES(3,'Pasha','Muhaylov','pasha@gmail.com','81dc9bdb52d04dc2036dbd8313ed055',1,1);
INSERT INTO users VALUES(4,'Petro','Semonenko','petro@gmail.com','81dc9bdb52d04dc2036dbd8313ed055',1,1);

INSERT INTO transactions VALUES(1,2,1,100,0);
INSERT INTO transactions VALUES(2,3,1,50,0);
INSERT INTO transactions VALUES(3,4,1,50,0);
INSERT INTO transactions VALUES(4,4,2,30,0);
INSERT INTO transactions VALUES(5,3,2,30,0);
INSERT INTO transactions VALUES(6,2,3,40,0);
INSERT INTO transactions VALUES(7,4,3,40,1);