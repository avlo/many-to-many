CREATE TABLE escalation (
     id INTEGER NOT NULL AUTO_INCREMENT,
     escalation_id INTEGER NOT NULL,
     name VARCHAR(128) NOT NULL,
     PRIMARY KEY (id)
);

CREATE TABLE request (
    id INTEGER NOT NULL AUTO_INCREMENT,
    request_id INTEGER NOT NULL,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE escalation_request (
    id INTEGER NOT NULL AUTO_INCREMENT,
    escalation_id INTEGER NOT NULL,
    request_id INTEGER NOT NULL,
    PRIMARY KEY (id)
);