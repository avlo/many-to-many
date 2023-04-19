CREATE TABLE escalation (
                         id   INTEGER      NOT NULL AUTO_INCREMENT,
                         name VARCHAR(128) NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE request (
                            id   INTEGER      NOT NULL AUTO_INCREMENT,
                            name VARCHAR(128) NOT NULL,
                            PRIMARY KEY (id)
);