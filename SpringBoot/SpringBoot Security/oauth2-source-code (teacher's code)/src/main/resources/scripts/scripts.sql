drop table if exists oauth_client_details;
create table oauth_client_details (
                                      client_id VARCHAR(255) PRIMARY KEY,
                                      resource_ids VARCHAR(255),
                                      client_secret VARCHAR(255),
                                      scope VARCHAR(255),
                                      authorized_grant_types VARCHAR(255),
                                      web_server_redirect_uri VARCHAR(255),
                                      authorities VARCHAR(255),
                                      access_token_validity INTEGER,
                                      refresh_token_validity INTEGER,
                                      additional_information VARCHAR(4096),
                                      autoapprove VARCHAR(255)
);


insert into oauth_client_details (client_id, client_secret, "scope", authorized_grant_types, access_token_validity, refresh_token_validity)
values ('client', '$2a$10$vTI1bXd2RHzofLxRa3KMkOPNAXVbFCONt1hwcobL9jvsLM9rK6Gmi', 'read,write', 'password,refresh_token', 36000, 360000);

insert into tbl_user (id, address, email, first_login, full_name, gender, is_locked, number_of_lock, "password", phone, username)
values ('1', 'phnom penh', 'tgi.student@gmail.com', true, 'tgi student', 'male', false, 1, '$2a$10$nVgsEH8pqX8z4/rsY1Zh1e7.Vb4oWdUaQC4SjbFZtM4YZkNY5OLpe', '012991821', 'GTISTUDENT');

INSERT INTO tbl_role (id, description, name) values ('1', 'role for admin', 'SUPER_ADMIN');

insert into tbl_user_role (user_id, role_id, id) values ('1', '1', '1');

inSERT INTO tbl_privilege (id, description, name) values ('1', 'can read priviledge', 'CUSTOMER_READ');
inSERT INTO tbl_privilege(id, description, name) values ('2', 'can create and edit priviledge', 'CUSTOMER_CREATE');
inSERT INTO tbl_privilege(id, description, name) values ('3', 'can delete priviledge', 'USER_READ');
inSERT INTO tbl_privilege(id, description, name) values ('4', 'can read role', 'USER_CREATE');
inSERT INTO tbl_privilege(id, description, name) values ('5', 'can create and edit role', 'ROLE_WRITE');
inSERT INTO tbl_privilege(id, description, name) values ('6', 'can delete role', 'ROLE_DELETE');
inSERT INTO tbl_privilege(id, description, name) values ('7', 'can read category', 'CATEGORY_READ');

insert into tbl_role_privilege (role_id, privilege_id, id) values ('1', '1', '1');
insert into tbl_role_privilege (role_id, privilege_id, id) values ('1', '2', '2');
insert into tbl_role_privilege (role_id, privilege_id, id) values ('1', '3', '3');
insert into tbl_role_privilege (role_id, privilege_id, id) values ('1', '4', '4');
insert into tbl_role_privilege (role_id, privilege_id, id) values ('1', '5', '5');
insert into tbl_role_privilege (role_id, privilege_id, id) values ('1', '6', '6');
insert into tbl_role_privilege (role_id, privilege_id, id) values ('1', '7', '7');