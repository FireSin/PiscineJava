INSERT INTO users (login, password)
VALUES ('Biba', 'Biba1');
INSERT INTO users (login, password)
VALUES ('Boba', 'Boba1');
INSERT INTO users (login, password)
VALUES ('Angela', 'Angela1');
INSERT INTO users (login, password)
VALUES ('Sama', 'Sama1');
INSERT INTO users (login, password)
VALUES ('Dick', 'Dick1');

INSERT INTO chatroom (name, owner_id)
VALUES ('Work', 4);
INSERT INTO chatroom (name, owner_id)
VALUES ('Shop', 3);
INSERT INTO chatroom (name, owner_id)
VALUES ('Neighbourhood', 1);
INSERT INTO chatroom (name, owner_id)
VALUES ('Sport', 1);
INSERT INTO chatroom (name, owner_id)
VALUES ('Family', 5);


INSERT INTO message (author_id, chatroom_id, text, date)
VALUES (1, 2, 'About turn! March!', TO_TIMESTAMP('2022-10-21 10:32:24', 'YYYY-MM-DD HH:MI:SS'));
INSERT INTO message (author_id, chatroom_id, text, date)
VALUES (2, 1, 'Away with a talk-show.', TO_TIMESTAMP('2022-10-9 8:30:20', 'YYYY-MM-DD HH:MI:SS'));
INSERT INTO message (author_id, chatroom_id, text, date)
VALUES (3, 2, 'Silence, you speakers!', TO_TIMESTAMP('2022-07-25 10:16:20', 'YYYY-MM-DD HH:MI:SS'));
INSERT INTO message (author_id, chatroom_id, text, date)
VALUES (4, 1, 'Comrade mauser, you have the floor.', TO_TIMESTAMP('2022-01-1 10:30:20', 'YYYY-MM-DD HH:MI:SS'));
INSERT INTO message (author_id, chatroom_id, text, date)
VALUES (1, 3, 'English, motherfaka, speak english!', TO_TIMESTAMP('2022-12-30 11:30:20', 'YYYY-MM-DD HH:MI:SS'));