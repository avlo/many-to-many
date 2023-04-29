CREATE TABLE escalation (
     id INTEGER NOT NULL AUTO_INCREMENT,
     escalation_id INTEGER NOT NULL,
     PRIMARY KEY (id)
);

CREATE TABLE request (
    id INTEGER NOT NULL AUTO_INCREMENT,
    request_id INTEGER NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE escalation_request (
    escalation_id INTEGER,
    request_id INTEGER
);