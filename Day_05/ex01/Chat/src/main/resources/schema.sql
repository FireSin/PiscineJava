CREATE TABLE IF NOT EXISTS users
(
	id SERIAL PRIMARY KEY,
	login TEXT NOT NULL UNIQUE,
	password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS chatrooms
(
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	owner_id INTEGER NOT NULL REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS messages
(
	id SERIAL PRIMARY KEY,
    author_id INTEGER NOT NULL REFERENCES users(id),
    chatroom_id INTEGER NOT NULL REFERENCES chatrooms(id),
    text TEXT NOT NULL,
    date TIMESTAMP
);
