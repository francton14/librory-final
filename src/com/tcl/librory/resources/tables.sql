CREATE TABLE librarians(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    FULLTEXT KEY librarians_i(username, first_name, last_name)
);

CREATE TABLE books(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    control_number BIGINT(20) UNIQUE NOT NULL,
    isbn VARCHAR(13),
    title VARCHAR(50) NOT NULL,
    author VARCHAR(255),
    publisher VARCHAR(255),
    published_date DATETIME,
    genre VARCHAR(50),
    librarian_id BIGINT(20) NOT NULL,
    FOREIGN KEY (librarian_id) REFERENCES librarians(id),
    FULLTEXT KEY books_i(title, author, publisher)
);

CREATE TABLE book_borrows(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    book_id BIGINT(20) NOT NULL,
    borrower VARCHAR(255) NOT NULL,
    librarian_id BIGINT(20) NOT NULL,
    start_date DATETIME NOT NULL,
    due_date DATETIME NOT NULL,
    returned_date DATETIME,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (librarian_id) REFERENCES librarians(id),
    FULLTEXT KEY borrows_i(borrower)
);