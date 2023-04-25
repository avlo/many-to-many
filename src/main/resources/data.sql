INSERT INTO requestnick (name) VALUES ('REQUEST 1');
INSERT INTO requestnick (name) VALUES ('REQUEST 2');
INSERT INTO requestnick (name) VALUES ('REQUEST 3');
INSERT INTO requestnick (name) VALUES ('REQUEST 4');
INSERT INTO requestnick (name) VALUES ('REQUEST 5');

INSERT INTO escalationnick (name) VALUES ( 'ESCALATION 1');
INSERT INTO escalationnick (name) VALUES ( 'ESCALATION 2');
INSERT INTO escalationnick (name) VALUES ( 'ESCALATION 3');
INSERT INTO escalationnick (name) VALUES ( 'ESCALATION 4');
INSERT INTO escalationnick (name) VALUES ( 'ESCALATION 5');

INSERT INTO escalationnick_requestnick (escalationnick_id, requestnick_id) VALUES (1, 1);
INSERT INTO escalationnick_requestnick (escalationnick_id, requestnick_id) VALUES (2, 2);
INSERT INTO escalationnick_requestnick (escalationnick_id, requestnick_id) VALUES (3, 3);
INSERT INTO escalationnick_requestnick (escalationnick_id, requestnick_id) VALUES (4, 4);
INSERT INTO escalationnick_requestnick (escalationnick_id, requestnick_id) VALUES (5, 5);