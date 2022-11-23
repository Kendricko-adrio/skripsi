CREATE TABLE courses
(
    id                 BIGSERIAL PRIMARY KEY NOT NULL,
    course_name        varchar(255) UNIQUE   NOT NULL,
    course_description varchar(255),
    course_price       bigint,
    created_by         bigint,
    created_at         BIGINT                NOT NULL,
    updated_at         BIGINT                NOT NULL
);

insert into courses (id, course_name, course_description, course_price, created_by, created_at, updated_at)
values (1, 'Java', 'Java is a programming language', 1000, 1, 0, 0);

insert into courses (id, course_name, course_description, course_price, created_by, created_at, updated_at)
values (2, 'Python', 'Python is a programming language', 2000, 1, 0, 0);

insert into courses (id, course_name, course_description, course_price, created_by, created_at, updated_at)
values (3, 'C++', 'C++ is a programming language', 3000, 1, 0, 0);

insert into courses (id, course_name, course_description, course_price, created_by, created_at, updated_at)
values (4, 'C#', 'C# is a programming language', 4000, 1, 0, 0);