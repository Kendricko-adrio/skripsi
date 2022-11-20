CREATE TABLE orders(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    course_id BIGINT,
    tutor_id BIGINT,
    is_active bool
)