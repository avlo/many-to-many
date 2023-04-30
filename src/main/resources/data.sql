INSERT INTO request (request_id, name) VALUES ( 1, 'REQUEST 1');
INSERT INTO request (request_id, name) VALUES (11, 'REQUEST 11');
INSERT INTO request (request_id, name) VALUES ( 2, 'REQUEST 2');
INSERT INTO request (request_id, name) VALUES ( 3, 'REQUEST 3');
INSERT INTO request (request_id, name) VALUES (33, 'REQUEST 33');
INSERT INTO request (request_id, name) VALUES ( 4, 'REQUEST 4');

INSERT INTO escalation (escalation_id, name) VALUES (111, 'ESCALATION 111');
INSERT INTO escalation (escalation_id, name) VALUES (222, 'ESCALATION 222');
INSERT INTO escalation (escalation_id, name) VALUES (333, 'ESCALATION 333');
-- INSERT INTO escalation (escalation_id) VALUES (444);
-- INSERT INTO escalation (escalation_id) VALUES (555);

INSERT INTO escalation_request (escalation_id, request_id) VALUES (111, 1);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (111, 11);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (222, 2);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (333, 3);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (333, 33);
-- INSERT INTO escalation_request (escalation_id, request_id) VALUES (5, 5);