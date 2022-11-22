create table roles
(
    id        BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

create table users
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(255) UNIQUE,
    email      VARCHAR(255),
    password   VARCHAR(255),
    name       VARCHAR(255),
    country_id BIGINT,
    role_id    BIGINT,
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);



create table countries
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

insert into roles(name)
values ('Student');
insert
into roles(name)
values ('Teacher');


insert into countries(id, name, created_at, updated_at)
values (1, 'Indonesia', 1, 1);
insert into countries(id, name, created_at, updated_at)
values (2, 'Singapore', 1, 1);

insert into users(username, email, password, name, country_id, created_at, updated_at, role_id)
values ('user1', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G', 'name1', 1, 1, 1, 1);

insert into users(username, email, password, name, country_id, created_at, updated_at, role_id)
values ('user2', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G', 'name2', 1, 1, 1, 2);

insert into users(username, email, password, name, country_id, created_at, updated_at, role_id)
values ('user3', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G', 'name3', 1, 1, 1, 1);

insert into users(username, email, password, name, country_id, created_at, updated_at, role_id)
values ('user4', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G', 'name4', 1, 1, 1, 2);
