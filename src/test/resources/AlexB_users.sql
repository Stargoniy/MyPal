CREATE DATABASE mypal_test;

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    active tinyint(1) DEFAULT 1,	
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    system tinyint(1) DEFAULT 0
) ENGINE=innodb AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

CREATE TABLE transactions(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    debit_id INT,
    credit_id INT,
    sum DOUBLE,
    status tinyint(1) DEFAULT 1
) ENGINE=innodb AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

INSERT INTO users VALUES(1,1,'Vasya','Germanov','admin@gmail.com','81dc9bdb52d04dc2036dbd8313ed055',0);
INSERT INTO users VALUES(2,1,'Alex','Vasnecov','alex@gmail.com','81dc9bdb52d04dc2036dbd8313ed055',0);
INSERT INTO users VALUES(3,1,'Pasha','Muhaylov','pasha@gmail.com','81dc9bdb52d04dc2036dbd8313ed055',0);
INSERT INTO users VALUES(4,1,'Petro','Semonenko','petro@gmail.com','81dc9bdb52d04dc2036dbd8313ed055',0);

INSERT INTO transactions VALUES(1,2,1,100,1);
INSERT INTO transactions VALUES(2,3,1,50,1);
INSERT INTO transactions VALUES(3,4,1,50,1);
INSERT INTO transactions VALUES(4,4,2,30,1);
INSERT INTO transactions VALUES(5,3,2,30,1);
INSERT INTO transactions VALUES(6,2,3,40,1);
INSERT INTO transactions VALUES(7,4,3,40,0);