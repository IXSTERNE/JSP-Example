
-- Drop tables if they exist
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS transactions;


-- Create the Books Table
CREATE TABLE books (
    book_id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    author TEXT NOT NULL,
    is_available BOOLEAN DEFAULT TRUE
);

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL
);

CREATE TABLE transactions (
    transaction_id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    date DATE NOT NULL
);

-- Insert Sample Records
INSERT INTO books (title, author, is_available) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 1),
('To Kill a Mockingbird', 'Harper Lee', 1),
('1984', 'George Orwell', 0),
('Pride and Prejudice', 'Jane Austen', 1),
('Moby Dick', 'Herman Melville', 1);

INSERT INTO users (name, email) VALUES
('Joules', 'ixsterne@gmail.com'),
('Maria', 'maria@db.com');

INSERT INTO transactions (user_id, book_id, date) VALUES
(1, 1, DATETIME('now')),
(2, 5, DATETIME('now'));

