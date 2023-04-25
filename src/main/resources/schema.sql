



CREATE TABLE escalationnick (
                         id   INTEGER      NOT NULL AUTO_INCREMENT,
                         name VARCHAR(128) NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE requestnick (
                            id   INTEGER      NOT NULL AUTO_INCREMENT,
                            name VARCHAR(128) NOT NULL,
                            PRIMARY KEY (id)
);

CREATE TABLE escalationnick_requestnick (
                         escalationnick_id   INTEGER,
                         requestnick_id   INTEGER
);