CREATE TABLE card (
                      id_card INT PRIMARY KEY AUTO_INCREMENT,
                      name_card VARCHAR(50) not null,
                      description_es VARCHAR(500) not null,
                        price VARCHAR(500) not null,
                        image VARCHAR(500) not null

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