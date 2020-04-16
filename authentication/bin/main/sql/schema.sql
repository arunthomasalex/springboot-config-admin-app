DROP TABLE if exists `usermanagement`.`oauth_client_details`;
CREATE TABLE `usermanagement`.`oauth_client_details` (
  client_id varchar(255) PRIMARY KEY,
  resource_ids varchar(255),
  client_secret varchar(255),
  scope varchar(255),
  authorized_grant_types varchar(255),
  web_server_redirect_uri varchar(255),
  authorities varchar(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information varchar(4096),
  autoapprove varchar(255)
);
 
DROP TABLE if exists `usermanagement`.`oauth_client_token`;
CREATE TABLE `usermanagement`.`oauth_client_token` (
  token_id varchar(255),
  token LONG VARBINARY,
  authentication_id varchar(255) PRIMARY KEY,
  user_name varchar(255),
  client_id varchar(255)
);
 
DROP TABLE if exists `usermanagement`.`oauth_access_token`;
CREATE TABLE `usermanagement`.`oauth_access_token` (
  token_id varchar(255),
  token LONG VARBINARY,
  authentication_id varchar(255) PRIMARY KEY,
  user_name varchar(255),
  client_id varchar(255),
  authentication LONG VARBINARY,
  refresh_token varchar(255)
);
 
DROP TABLE if exists `usermanagement`.`oauth_refresh_token`;
CREATE TABLE `usermanagement`.`oauth_refresh_token` (
  token_id varchar(255),
  token LONG VARBINARY,
  authentication LONG VARBINARY
);
 
DROP TABLE if exists `usermanagement`.`oauth_code`;
CREATE TABLE `usermanagement`.`oauth_code` (
  code varchar(255), authentication LONG VARBINARY
);
 
DROP TABLE if exists `usermanagement`.`oauth_approvals`;
CREATE TABLE `usermanagement`.`oauth_approvals` (
    userId varchar(255),
    clientId varchar(255),
    scope varchar(255),
    status varchar(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);

DROP TABLE if exists `usermanagement`.`users`;
CREATE TABLE `usermanagement`.`users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_expired` bit(1) DEFAULT NULL,
  `account_locked` bit(1) DEFAULT NULL,
  `credentials_expired` bit(1) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE if exists `usermanagement`.`user_details`;
CREATE TABLE `usermanagement`.`user_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKicouhgavvmiiohc28mgk0kuj5` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE if exists `usermanagement`.`role`;
CREATE TABLE `usermanagement`.`role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE if exists `usermanagement`.`users_roles`;
CREATE TABLE `usermanagement`.`users_roles` (
  `user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  UNIQUE KEY `UK_amwlmdeik2qdnksxgd566knop` (`roles_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;