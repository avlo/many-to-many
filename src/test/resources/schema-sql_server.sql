-- drop table if exists escalation;
-- drop table if exists request;
-- drop table if exists escalation_request;

CREATE TABLE escalation (
    id INT IDENTITY(1,1),
    escalation_id INTEGER NOT NULL,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE request (
    id INT IDENTITY(1,1),
    request_id INTEGER NOT NULL,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE escalation_request (
    id INT IDENTITY(1,1),
    escalation_id INTEGER NOT NULL,
    request_id INTEGER NOT NULL,
    PRIMARY KEY (id)
);