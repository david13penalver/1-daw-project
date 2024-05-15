CREATE DATABASE IF NOT EXISTS dimentials;

USE dimentials;

CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON dimentials.* TO 'root'@'localhost';

insert INTO card VALUES (1, 'Lavacus', 'Escudo (1): Genera 1 de armadura al final de cada uno de tus turnos. La armadura se suma a la vida y se consume cuando tu legión dimensional es atacada. La armadura de esta habilidad es acumulable y la que no es consumida permanece incluso cuando la legión evoluciona.' ,'Shield (1): Generates 1 armor at the end of each of your turns. The armor is added to life and is consumed when your dimensional legion is attacked. The armor of this ability is cumulative and that which is not consumed remains even when the legion evolves.', 10.00, '/images/CardDetail/card1.png');
insert INTO monster VALUES (1,1, 1, 'Roca',  'Rock', 'Fuego', 'Fire');

insert INTO card VALUES (2, 'Pyromagmus', 'Armadura (6): Al entrar en combate, se suma 6 de armadura hasta el principio de su siguiente turno. La armadura se suma a la vida y se consume primero cuando la legión dimential es atacada.' ,'Armor (6): When entering combat, you add 6 armor until the beginning of your next turn. Armor is added to life and is consumed first when the dimential legion is attacked.', 14.00, '/images/CardDetail/card2.png');

insert INTO monster VALUES (2, 3, 3, 'Roca',  'Rock', 'Fuego', 'Fire');

insert INTO card VALUES (3, 'Aurelius Ignis', 'Invocación: Al entrar en el campo de batalla, invoca de forma especial a su izq. y der. "Los Brazos de Aurelius Ignis", una legión lv1 de misma especie y elementos que Aurelius, con estadísticas 3/1 y con la habilidad Contraataque.

Contraataque: Cuando recibe un golpe de otra legión cercana, lo devuelve con su poder de ataque.', 'Summon: When he enters the battlefield, he special summons to his left and right “The Arms of Aurelius Ignis”, a lv1 legion of the same species and elements as Aurelius, with 3/1 stats and with the ability Counterattack.

Counterattack: When he receives a hit from another nearby legion, he strikes back with his attack power.', 17.00, '/images/CardDetail/card3.png');

insert INTO monster VALUES (3, 8, 3, 'Roca',  'Rock', 'Fuego', 'Fire');