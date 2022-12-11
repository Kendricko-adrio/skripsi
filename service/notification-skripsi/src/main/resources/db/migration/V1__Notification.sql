create table notifications
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT       NOT NULL,
    content VARCHAR(255) NOT NULL,
    read    BOOLEAN      NOT NULL DEFAULT FALSE
);

insert into notifications (user_id, content, read)
values (1, 'Hello World', false),
       (1, 'You have new notification bro', false);
