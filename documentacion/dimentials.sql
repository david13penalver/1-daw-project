CREATE DATABASE dimentials;

USE dimentials;

-- Client table
CREATE TABLE client (
    id_client INT PRIMARY KEY,
    name VARCHAR(255) not null,
    surname1 VARCHAR(255) not null,
    surname2 VARCHAR(255),
    is_admin BOOLEAN not null,
    email VARCHAR(255) not null

);

-- Card table
CREATE TABLE card (
    id_card INT PRIMARY KEY,
    name VARCHAR(255) not null,
    description VARCHAR(500) not null,
    price DECIMAL(10, 2) not null
);

-- Monsters table
CREATE TABLE monster (
    id_card INT PRIMARY KEY,
    atack INT not null,
    life INT not null,
    main_type  VARCHAR(20) not null,
    socondary_type VARCHAR(20),
    FOREIGN KEY (id_card) REFERENCES card(id_card) ON DELETE CASCADE
);

-- Spell table
CREATE TABLE spell (
    id_card INT PRIMARY KEY,
    mana INT not null,
    FOREIGN KEY (id_card) REFERENCES card(id_card) ON DELETE CASCADE
);

-- Order table
CREATE TABLE order_global (
    id_order_global INT PRIMARY KEY,
    id_client INT,
    status boolean not null,
    date_creation DATETIME not null,
    date_close DATETIME not null,
    total DECIMAL(10, 2) not null,
    FOREIGN KEY (id_client) REFERENCES client(id_client) ON DELETE CASCADE
);

-- Order_details table
CREATE TABLE order_detail (
    id_order_detail INT PRIMARY KEY,
    id_order_global INT,
    id_card INT,
    price DECIMAL(10, 2) not null,
    quantity INT not null,
    FOREIGN KEY (id_order_global) REFERENCES order_global(id_order_global) ON DELETE CASCADE,
    FOREIGN KEY (id_card) REFERENCES card(id_card) ON DELETE CASCADE
);

DROP DATABASE IF EXISTS dimentials;