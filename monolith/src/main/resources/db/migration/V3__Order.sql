CREATE TABLE orders(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    course_id BIGINT,
    teacher_id BIGINT,
    is_active bool,
    created_at BIGINT,
    updated_at BIGINT
)