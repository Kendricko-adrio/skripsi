create table notifications
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT       NOT NULL,
    content VARCHAR(255) NOT NULL,
    read    BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at BIGINT                NOT NULL,
    updated_at BIGINT                NOT NULL
);

insert into notifications (user_id, content, read, created_at, updated_at)
values (1, 'Hello World', false, 0, 0),
       (1, 'You have new notification bro', false, 0, 0);
insert into notifications (user_id, content, read, created_at, updated_at)
values (3, 'JOB_APPLICATION_REJECTION', false, 0, 0);
