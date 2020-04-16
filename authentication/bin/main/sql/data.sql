INSERT INTO `usermanagement`.`oauth_client_details` (client_id, client_secret, scope, access_token_validity, refresh_token_validity, authorized_grant_types, web_server_redirect_uri)
VALUES ('client', '$2a$10$/m9Bgwm1rAttRchmMwOSeuAl1xLR6M.hLnKoIn.siKxWYMd2in4Fq', 'read,write', 200, 200, 'authorization_code', 'http://localhost:8000/home');

INSERT INTO `usermanagement`.`oauth_client_details` (client_id, client_secret, scope, access_token_validity, refresh_token_validity, authorized_grant_types, web_server_redirect_uri)
VALUES ('admin', '$2a$10$/m9Bgwm1rAttRchmMwOSeuAl1xLR6M.hLnKoIn.siKxWYMd2in4Fq', 'read,write', 200, 200, 'password,refresh_token,client_credentials,implicit', null);

INSERT INTO `usermanagement`.`users` (`id`, `account_expired`, `account_locked`, `credentials_expired`, `enabled`, `password`, `username`)
VALUES (1, false, false, false, true, "$2a$10$/m9Bgwm1rAttRchmMwOSeuAl1xLR6M.hLnKoIn.siKxWYMd2in4Fq", "arun");

INSERT INTO  `usermanagement`.`user_details` (`dob`, `email`, `firstname`, `lastname`, `gender`, `user_id`) 
VALUES ('1988-7-10', "arunthomasalex@gmail.com", "Arun Thomas", "Alex", "Male", 1);

INSERT INTO `usermanagement`.`role` (`id`, `name`)
VALUES (1, "ADMIN");

INSERT INTO `usermanagement`.`role` (`id`, `name`)
VALUES (2, "USER");


INSERT INTO `usermanagement`.`users_roles` (`user_id`, `roles_id`)
VALUES (1, 1);

INSERT INTO `usermanagement`.`users_roles` (`user_id`, `roles_id`)
VALUES (1, 2);