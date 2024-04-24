CREATE DATABASE IF NOT EXISTS dimentials;

USE dimentials;

-- User table
CREATE TABLE user (
    id_client INT PRIMARY KEY,
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
    id_card INT PRIMARY KEY, -- PREGUNTAR SI AL ESTAR ABAJO HAY QUE ELIMINARLA
    atack INT not null,
    life INT not null,
    main_type_es  VARCHAR(20) not null,
    main_type_en  VARCHAR(20) not null,
    socondary_type_es VARCHAR(20),
    socondary_type_en VARCHAR(20),
    FOREIGN KEY (id_card) REFERENCES card(id_card) ON DELETE CASCADE
);

-- Spell table
CREATE TABLE spell (
    id_card INT PRIMARY KEY, -- PREGUNTAR SI AL ESTAR ABAJO HAY QUE ELIMINARLA
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
); -- NO CREA POR LA REFERENCIA A LA TABLA CLIENTE

-- Order_details table
CREATE TABLE order_detail (
    id_order_detail INT PRIMARY KEY,
    id_order_global INT,
    id_card INT,
    price DECIMAL(10, 2) not null, -- ES EL MISMO QUE EN CARD, HABRÍA QUE COGERLO DE AHÍ
    quantity INT not null, -- TIENE QUE SER UN CAMPO QUE MULTIPLICA PRICE * QUANTITY
    FOREIGN KEY (id_order_global) REFERENCES order_global(id_order_global) ON DELETE CASCADE,
    FOREIGN KEY (id_card) REFERENCES card(id_card) ON DELETE CASCADE
);