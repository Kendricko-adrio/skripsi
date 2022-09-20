create table users(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    email VARCHAR(255)
);

insert into users(id, username, password,email) values (1,'user1', 'password', 'email@email.com');
insert into users(id, username, password,email) values (2,'user2', 'password', 'email@email.com');
insert into users(id, username, password,email) values (3,'user3', 'password', 'email@email.com');
insert into users(id, username, password,email) values (4,'user4', 'password', 'email@email.com');