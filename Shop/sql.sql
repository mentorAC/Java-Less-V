-- select * from products

CREATE TABLE Role(
id BIGSERIAL PRIMARY KEY,
name varchar(20) NOT NULL
);

CREATE TABLE "User"(
id BIGSERIAL   PRIMARY KEY,
username varchar(20) NOT NULL UNIQUE,
email varchar(40),
phone varchar(15),
passwordHash varchar NOT NULL
);

CREATE TABLE UserRole(
userId int,
roleId int,

CONSTRAINT userRole_pk PRIMARY KEY(userId, roleId),
CONSTRAINT userRole_User_fk FOREIGN KEY(userId) REFERENCES "User"(id),
CONSTRAINT userRole_Rol_fk FOREIGN KEY(roleId) REFERENCES Role(id)

);