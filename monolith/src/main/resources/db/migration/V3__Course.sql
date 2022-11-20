CREATE TABLE courses(
    id BIGSERIAL PRIMARY KEY NOT NULL ,
    course_name varchar(255) UNIQUE NOT NULL ,
    course_description varchar(255),
    course_price bigint,
    created_by bigint
);

