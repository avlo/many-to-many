



CREATE TABLE escalation_nick (
                         id   INTEGER      NOT NULL AUTO_INCREMENT,
                         name VARCHAR(128) NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE request_nick (
                            id   INTEGER      NOT NULL AUTO_INCREMENT,
                            name VARCHAR(128) NOT NULL,
                            PRIMARY KEY (id)
);

CREATE TABLE escalation_request_nick (
                         escalation_id   INTEGER,
                         request_id   INTEGER
);