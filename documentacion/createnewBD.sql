CREATE DATABASE monster_battler;

USE monster_battler;

CREATE TABLE user (
  id_user INT PRIMARY KEY,
  surname1 VARCHAR(255) NOT NULL,
  surname2 VARCHAR(255) NOT NULL,
  id_card VARCHAR(255) NOT NULL
);

CREATE TABLE monster (
  main_type VARCHAR(255) NOT NULL,
  secondary_type VARCHAR(255),
  attack INT,
  defense INT,
  spell VARCHAR(255),
  mana INT,
  description TEXT,
  price DECIMAL(10,2)
);

CREATE TABLE order (
  id_order INT PRIMARY KEY,
  status VARCHAR(255) NOT NULL,
  date_creation DATETIME NOT NULL,
  date_close DATETIME
);

CREATE TABLE order_detail (
  id_order_detail INT PRIMARY KEY,
  id_order INT NOT NULL,
  monster_disjoint INT NOT NULL,
  monster_partial INT NOT NULL,
  quantity INT NOT NULL,
  FOREIGN KEY (id_order) REFERENCES order(id_order)
);

ALTER TABLE monster ADD CONSTRAINT monster_unique UNIQUE (main_type, secondary_type);

ALTER TABLE order_detail ADD CONSTRAINT monster_detail_fk FOREIGN KEY (monster_disjoint) REFERENCES monster(main_type);

ALTER TABLE order_detail ADD CONSTRAINT monster_detail_partial_fk FOREIGN KEY (monster_partial) REFERENCES monster(main_type);
