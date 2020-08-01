# noinspection SqlNoDataSourceInspectionForFile
INSERT INTO USERS (ID, PASSWORD, Email) VALUES (1, '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi','admin@localhost');
INSERT INTO USERS (ID, PASSWORD, Email) VALUES (2, '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','user@localhost');

INSERT INTO AUTHORITY (NAME) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (NAME) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_NAME) VALUES (2, 'ROLE_USER');
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_NAME) VALUES (1, 'ROLE_ADMIN');


