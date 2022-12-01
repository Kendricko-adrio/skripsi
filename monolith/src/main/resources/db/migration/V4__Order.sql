CREATE TABLE orders
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    course_id  BIGINT,
    teacher_id   BIGINT,
    student_id BIGINT,
    is_active  bool DEFAULT true,
    created_at BIGINT                NOT NULL,
    updated_at BIGINT                NOT NULL
);

CREATE TABLE job_vacancies
(
    id              BIGSERIAL PRIMARY KEY NOT NULL,
    course_id       BIGINT,
    student_id      BIGINT,
    description     VARCHAR(255),
    is_active       bool DEFAULT true,
    mark_for_delete bool DEFAULT false,
    created_at      BIGINT                NOT NULL,
    updated_at      BIGINT                NOT NULL
);

CREATE TABLE job_applications
(
    job_vacancy_id  BIGINT NOT NULL,
    teacher_id        BIGINT NOT NULL,
    approval_status VARCHAR(55),
    mark_for_delete bool DEFAULT false,
    created_at      BIGINT    NOT NULL,
    updated_at      BIGINT    NOT NULL,
    PRIMARY KEY (job_vacancy_id, teacher_id)
);

insert into job_vacancies (id, course_id, student_id, description, is_active, mark_for_delete,
                           created_at, updated_at)
values (1, 1, 1, 'test job', true, false, 0, 0);
insert into job_vacancies (id, course_id, student_id, description, is_active, mark_for_delete,
                           created_at, updated_at)
values (2, 2, 1, 'test job 2', true, false, 0, 0);
insert into job_vacancies (id, course_id, student_id, description, is_active, mark_for_delete,
                           created_at, updated_at)
values (3, 2, 1, 'test job 3', true, false, 0, 0);
insert into job_vacancies (id, course_id, student_id, description, is_active, mark_for_delete,
                           created_at, updated_at)
values (4, 2, 1, 'test job 4', true, false, 0, 0);


insert into job_applications (job_vacancy_id, teacher_id, approval_status, mark_for_delete,
                              created_at, updated_at)
values (1, 3, 'PENDING', false, 0, 0);
insert into job_applications (job_vacancy_id, teacher_id, approval_status, mark_for_delete,
                              created_at, updated_at)
values (1, 4, 'APPROVED', false, 0, 0);
insert into job_applications (job_vacancy_id, teacher_id, approval_status, mark_for_delete,
                              created_at, updated_at)
values (2, 3, 'REJECTED_BY_STUDENT', false, 0, 0);
insert into job_applications (job_vacancy_id, teacher_id, approval_status, mark_for_delete,
                              created_at, updated_at)
values (2, 4, 'CANCELLED_BY_TEACHER', false, 0, 0);

insert into orders (course_id, teacher_id, student_id, is_active, created_at, updated_at)
values (1, 3, 1, true, 0, 0);

