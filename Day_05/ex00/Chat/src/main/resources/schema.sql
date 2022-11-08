CREATE TABLE message
(
	id SERIAL PRIMARY KEY,
    author_id INTEGER NOT NULL REFERENCES user(id),
    chatroom_id INTEGER NOT NULL REFERENCES chatroom(id),
    text TEXT NOT NULL,
    date TIMESTAMP
);

CREATE TABLE users
(
	id SERIAL PRIMARY KEY,
	login TEXT NOT NULL,
	password TEXT NOT NULL,
);

CREATE TABLE chatroom
(
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	owner_id INTEGER NOT NULL REFERENCES user(id),
);