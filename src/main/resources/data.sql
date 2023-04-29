INSERT INTO request (request_id) VALUES (1);
INSERT INTO request (request_id) VALUES (11);
INSERT INTO request (request_id) VALUES (2);
INSERT INTO request (request_id) VALUES (3);
INSERT INTO request (request_id) VALUES (33);
INSERT INTO request (request_id) VALUES (4);

INSERT INTO escalation (escalation_id) VALUES (111);
INSERT INTO escalation (escalation_id) VALUES (222);
INSERT INTO escalation (escalation_id) VALUES (333);
-- INSERT INTO escalation (escalation_id) VALUES (444);
-- INSERT INTO escalation (escalation_id) VALUES (555);

INSERT INTO escalation_request (escalation_id, request_id) VALUES (111, 1);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (111, 11);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (222, 2);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (333, 3);
INSERT INTO escalation_request (escalation_id, request_id) VALUES (333, 33);
-- INSERT INTO escalation_request (escalation_id, request_id) VALUES (5, 5);