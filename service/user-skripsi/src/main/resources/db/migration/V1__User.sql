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


-- DATA INSERTION

insert into roles(name, created_at, updated_at)
values ('Student', 0, 0);

insert into roles(name, created_at, updated_at)
values ('Teacher', 0, 0);
--
insert into countries( name, created_at, updated_at)
values ('Indonesia', 0, 0);
insert into countries(name, created_at, updated_at)
values ('Singapore', 0, 0);

insert into users(username, email, password, name, country_id, role_id, created_at, updated_at)
values ('student1', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G',
        'Student Pertama', 1, 1, 0, 0);

insert into users(username, email, password, name, country_id, role_id, created_at, updated_at)
values ('student 2', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G',
        'Student Kedua', 2, 1, 0, 0);

insert into users(username, email, password, name, country_id, role_id, created_at, updated_at)
values ('teacher1', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G',
        'Teacher Pertama', 1, 2, 0, 0);

insert into users(username, email, password, name, country_id, role_id, created_at, updated_at)
values ('teacher2', 'email@email.com', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G',
        'Teacher Kedua', 2, 2, 0, 0);

