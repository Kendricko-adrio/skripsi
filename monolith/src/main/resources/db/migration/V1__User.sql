create table users(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    email VARCHAR(255)
);

insert into users(username, password,email) values ('user1', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G', 'email@email.com');
insert into users(username, password,email) values ('user2', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G', 'email@email.com');
insert into users(username, password,email) values ('user3', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G', 'email@email.com');
insert into users(username, password,email) values ('user4', '$2a$10$W/tLF9I8R5WrMEZ/4R0i0OQm8/lDu9Jaf7rzCDsYFKEmfjHiyr21G', 'email@email.com');