-- create table notifications
-- (
--     id      BIGSERIAL PRIMARY KEY,
--     user_id BIGINT       NOT NULL,
--     content VARCHAR(255) NOT NULL,
--     read    BOOLEAN      NOT NULL DEFAULT FALSE
-- );

<<<<<<< HEAD
-- insert into notifications (id, user_id, content, read)
-- values (1, 1, 'Hello World', false),
--        (2, 1, 'You have new notification bro', false);
=======
insert into notifications (user_id, content, read)
values (1, 'Hello World', false),
       (1, 'You have new notification bro', false);
>>>>>>> c3d3e0305b04b0f59a1ae850f0c66fb071c03b02
