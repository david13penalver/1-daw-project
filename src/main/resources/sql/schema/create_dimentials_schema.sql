CREATE DATABASE IF NOT EXISTS dimentials;

USE dimentials;

-- User table
CREATE TABLE user (
    id_user INT PRIMARY KEY,
    name_user VARCHAR(50) not null,
    surname1 VARCHAR(25) not null,
    surname2 VARCHAR(25),
    is_admin BOOLEAN not null,
    email VARCHAR(55) not null
);

-- Card table
CREATE TABLE card (
    id_card INT PRIMARY KEY,
    name_card VARCHAR(50) not null,
    description_es VARCHAR(500) not null,
    description_en VARCHAR(500) not null,
    price DECIMAL(10, 2) not null,
    image VARCHAR(200) not null
);

-- Monsters table
CREATE TABLE monster (
    id_card INT PRIMARY KEY, 
    attack INT not null,
    life INT not null,
    main_type_es  VARCHAR(20) not null,
    main_type_en  VARCHAR(20) not null,
    secondary_type_es VARCHAR(20),
    secondary_type_en VARCHAR(20),
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
    id_user INT,
    status boolean not null,
    date_creation DATETIME not null,
    date_close DATETIME not null,
    total DECIMAL(10, 2) not null, -- TIENE QUE HACER LA SUMA DE LOS PRICE DE ORDER_DETAIL
    FOREIGN KEY (id_user) REFERENCES user(id_user) ON DELETE CASCADE
); 

-- Order_details table
CREATE TABLE order_detail (
    id_order_detail INT PRIMARY KEY,
    id_order_global INT,
    id_card INT,
    price DECIMAL(10, 2) not null, -- TIENE QUE SER UN CAMPO QUE MULTIPLICA PRICE * QUANTITY
    quantity INT not null,
    FOREIGN KEY (id_order_global) REFERENCES order_global(id_order_global) ON DELETE CASCADE,
    FOREIGN KEY (id_card) REFERENCES card(id_card) ON DELETE CASCADE
);