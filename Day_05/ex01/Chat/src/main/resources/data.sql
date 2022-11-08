INSERT INTO users (login, password) VALUES ('user1', '123'), ('user2', '123'), ('user3', '123'), ('user4', '123'), ('user5', '123');
INSERT INTO chatrooms (name, owner_id) VALUES ('room1', 1), ('room2', 2), ('room3', 3), ('room4', 4), ('room5', 5);
INSERT INTO messages (author_id, chatroom_id, text, date) VALUES (1, 1, 'hello from user1', NOW()), (2, 1, 'hello from user2', NOW()), (3, 2, 'hello from user3', NOW()), (4, 2, 'hello from user4', NOW()), (1, 5, 'hello from user1', NOW());
