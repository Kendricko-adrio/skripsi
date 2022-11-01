create table countries
(
    id         BIGSERIAL PRIMARY KEY,
    name   VARCHAR(255),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

insert into countries(id, name, created_at, updated_at)
values (1, 'Indonesia', 1, 1);
insert into countries(id, name, created_at, updated_at)
values (2, 'Singapore', 1, 1);