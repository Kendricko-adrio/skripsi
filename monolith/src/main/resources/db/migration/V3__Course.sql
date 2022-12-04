CREATE TABLE courses
(
    id                 BIGSERIAL PRIMARY KEY NOT NULL,
    course_name        varchar(255) UNIQUE   NOT NULL,
    course_description varchar(255),
    course_price       BIGINT,
    created_at         BIGINT                NOT NULL,
    created_by         BIGINT,
    updated_at         BIGINT                NOT NULL
);

CREATE TABLE chapters
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    name       VARCHAR(255)          NOT NULL,
    detail     VARCHAR(255),
    course_id  BIGINT                NOT NULL,
    created_at BIGINT                NOT NULL,
    updated_at BIGINT                NOT NULL
);

insert into courses (id, course_name, course_description, course_price, created_by, created_at,
                     updated_at)
values (1, 'Java', 'Java is a programming language', 1000, 1, 0, 0);

insert into courses (id, course_name, course_description, course_price, created_by, created_at,
                     updated_at)
values (2, 'Python', 'Python is a programming language', 1, 2000, 0, 0);

insert into courses (id, course_name, course_description, course_price, created_by, created_at,
                     updated_at)
values (3, 'C++', 'C++ is a programming language', 3000, 1, 0, 0);

insert into courses (id, course_name, course_description, course_price, created_by, created_at,
                     updated_at)
values (4, 'C#', 'C# is a programming language', 4000, 1, 0, 0);

-- chapters
insert into chapters(id, name, detail, course_id, created_at, updated_at)
values (1, 'Introduction', 'Introduction to Java', 1, 0, 0),
       (2, 'Basic', 'Basic of Java', 1, 0, 0),
       (3, 'Advanced', 'Advanced of Java', 1, 0, 0);
insert into chapters(id, name, detail, course_id, created_at, updated_at)
values (4, 'Introduction', 'Introduction to Python', 2, 0, 0),
       (5, 'Basic', 'Basic of Python', 2, 0, 0),
       (6, 'Advanced', 'Advanced of Python', 2, 0, 0);