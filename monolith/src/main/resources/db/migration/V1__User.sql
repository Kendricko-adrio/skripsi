-- TABLE CREATION

create table users
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(255) UNIQUE,
    email      VARCHAR(255),
    password   VARCHAR(255),
    name       VARCHAR(255),
    role_id    BIGSERIAL,
    country_id BIGSERIAL,
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

CREATE TABLE roles
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE TABLE notifications
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGSERIAL,
    content    VARCHAR(255),
    read       BOOLEAN,
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

-- DATA INSERTION

insert into roles(id, name, created_at, updated_at)
values (1, 'Student', 0, 0);

insert into roles(id, name, created_at, updated_at)
values (2, 'Teacher', 0, 0);
--
insert into countries(id, name, created_at, updated_at)
values (1, 'Indonesia', 0, 0);
insert into countries(id, name, created_at, updated_at)
values (2, 'Singapore', 0, 0);

insert into users(username, email, password, name, country_id, role_id, created_at, updated_at)
values ('user1', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G',
        'name1', 1, 1, 0, 0);

insert into users(username, email, password, name, country_id, role_id, created_at, updated_at)
values ('user2', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G',
        'name2', 2, 1, 0, 0);

insert into users(username, email, password, name, country_id, role_id, created_at, updated_at)
values ('user3', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G',
        'name3', 1, 2, 0, 0);

insert into users(username, email, password, name, country_id, role_id, created_at, updated_at)
values ('user4', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G',
        'name4', 2, 2, 0, 0);

insert into notifications(user_id, content, read, created_at, updated_at)
values (1, 'content1', false, 0, 0);
insert into notifications(user_id, content, read, created_at, updated_at)
values (1, 'content2', false, 0, 0);
