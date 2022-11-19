INSERT INTO privilege (privilege_id, name, description) VALUES (1, 'PRIVILEGE_ADMIN_READ', 'description for privilege admin read');
INSERT INTO privilege (privilege_id, name, description) VALUES (2, 'PRIVILEGE_USER_READ', 'description for privilege user read');

INSERT INTO role (role_id, name, description) VALUES (1, 'ROLE_ADMIN', 'description for role admin');
INSERT INTO role (role_id, name, description) VALUES (2, 'ROLE_USER', 'description for role user');

INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (1, 1);
INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (2, 2);

INSERT INTO account (id, enabled, username, password) VALUES (1, true, 'admin', '$2a$10$MTFVrdqbHOi.CCUhkrkZnOBdrZEfk3gzIUyZBdQvLWvdF/0pnkEO2');
INSERT INTO account (id, enabled, username, password) VALUES (2, true, 'user', '$2a$10$6KDklkImZgGANWR8pDAwSexf6Bt4Z9I0nDiwdih9Q38HI4eAkWk0u');

INSERT INTO account_roles (account_id, roles_role_id) VALUES (1, 1);
INSERT INTO account_roles (account_id, roles_role_id) VALUES (2, 2);


INSERT INTO privilege (privilege_id, name, description) VALUES (3, 'PRIVILEGE_SALE_INVOICE', 'description for privilege sale read');
--  password = user
INSERT INTO account (id, enabled, username, password) VALUES (3, true, 'sale', '$2a$10$6KDklkImZgGANWR8pDAwSexf6Bt4Z9I0nDiwdih9Q38HI4eAkWk0u');
INSERT INTO role (role_id, name, description) VALUES (3, 'ROLE_SALE', 'description for role sale');
INSERT INTO account_roles (account_id, roles_role_id) VALUES (3, 3);
INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (3, 3);
