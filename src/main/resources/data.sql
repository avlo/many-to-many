INSERT INTO request (name) VALUES ('REQUEST 1');
INSERT INTO request (name) VALUES ('REQUEST 2');
INSERT INTO request (name) VALUES ('REQUEST 3');
INSERT INTO request (name) VALUES ('REQUEST 4');
INSERT INTO request (name) VALUES ('REQUEST 5');

INSERT INTO escalation (name) VALUES ( 'ESCALATION 1');
INSERT INTO escalation (name) VALUES ( 'ESCALATION 2');
INSERT INTO escalation (name) VALUES ( 'ESCALATION 3');
INSERT INTO escalation (name) VALUES ( 'ESCALATION 4');
INSERT INTO escalation (name) VALUES ( 'ESCALATION 5');

INSERT INTO escalation_request (escalation_id, request_id) VALUES (1, 1);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (2, 2);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (3, 3);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (4, 4);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (5, 5);