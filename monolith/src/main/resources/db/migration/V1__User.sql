create table users(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    email VARCHAR(255),
    password VARCHAR(255),
    name VARCHAR(255),
    country_id BIGINT,
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

insert into users(id, username, email, password, name, country_id, created_at, updated_at) values
(1, 'user1', 'email@email.com', 'password', 'name1', 1, 1, 1);

insert into users(id, username, email, password, name, country_id, created_at, updated_at) values
(2, 'user2', 'email@email.com', 'password', 'name2', 1, 1, 1);

insert into users(id, username, email, password, name, country_id, created_at, updated_at) values
(3, 'user3', 'email@email.com', 'password', 'name3', 1, 1, 1);

insert into users(id, username, email, password, name, country_id, created_at, updated_at) values
(4, 'user4', 'email@email.com', 'password', 'name4', 1, 1, 1);
