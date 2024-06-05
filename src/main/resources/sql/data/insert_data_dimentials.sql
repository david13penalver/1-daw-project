CREATE DATABASE IF NOT EXISTS dimentials;

USE dimentials;


-- ROLES Y USUARIOS


CREATE ROLE IF NOT EXISTS 'dimentials_admin';
GRANT ALL PRIVILEGES ON dimentials.* TO 'dimentials_admin';
CREATE USER 'generaladmin'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE;

CREATE USER 'dpenalver'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE;
CREATE USER 'asuarez'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE;
CREATE USER 'brubio'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE;
GRANT 'dimentials_admin' TO 'dpenalver'@'localhost';
GRANT 'dimentials_admin' TO 'asuarez'@'localhost';
GRANT 'dimentials_admin' TO 'brubio'@'localhost';

CREATE USER 'viewer'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT ON dimentials.card TO 'viewer'@'localhost';
GRANT SELECT ON dimentials.monster TO 'viewer'@'localhost';
GRANT SELECT ON dimentials.spell TO 'viewer'@'localhost';

CREATE ROLE 'client';
GRANT SELECT ON dimentials.card TO 'client';
GRANT SELECT ON dimentials.monster TO 'client';
GRANT SELECT ON dimentials.spell TO 'client';
GRANT SELECT, INSERT, UPDATE, DELETE ON dimentials.order_detail TO 'client';
GRANT UPDATE ON dimentials.user TO 'client';

CREATE USER 'client1'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE;
GRANT 'client' TO 'client1'@'localhost';


-- INSERCIONES


insert INTO card VALUES (1, 'Lavacus', 'Escudo (1): Genera 1 de armadura al final de cada uno de tus turnos. La armadura se suma a la vida y se consume cuando tu legión dimensional es atacada. La armadura de esta habilidad es acumulable y la que no es consumida permanece incluso cuando la legión evoluciona.' ,'Shield (1): Generates 1 armor at the end of each of your turns. The armor is added to life and is consumed when your dimensional legion is attacked. The armor of this ability is cumulative and that which is not consumed remains even when the legion evolves.', 10.00, '/images/CardDetail/card1.png');
insert INTO monster VALUES (1,1, 1, 'Roca',  'Rock', 'Fuego', 'Fire');

insert INTO card VALUES (2, 'Pyromagmus', 'Armadura (6): Al entrar en combate, se suma 6 de armadura hasta el principio de su siguiente turno. La armadura se suma a la vida y se consume primero cuando la legión dimential es atacada.' ,'Armor (6): When entering combat, you add 6 armor until the beginning of your next turn. Armor is added to life and is consumed first when the dimential legion is attacked.', 14.00, '/images/CardDetail/card2.png');

insert INTO monster VALUES (2, 3, 3, 'Roca',  'Rock', 'Fuego', 'Fire');

insert INTO card VALUES (3, 'Aurelius Ignis', 'Invocación: Al entrar en el campo de batalla, invoca de forma especial a su izq. y der. "Los Brazos de Aurelius Ignis", una legión lv1 de misma especie y elementos que Aurelius, con estadísticas 3/1 y con la habilidad Contraataque.

Contraataque: Cuando recibe un golpe de otra legión cercana, lo devuelve con su poder de ataque.', 'Summon: When he enters the battlefield, he special summons to his left and right “The Arms of Aurelius Ignis”, a lv1 legion of the same species and elements as Aurelius, with 3/1 stats and with the ability Counterattack.

Counterattack: When he receives a hit from another nearby legion, he strikes back with his attack power.', 17.00, '/images/CardDetail/card3.png');

insert INTO monster VALUES (3, 8, 3, 'Roca',  'Rock', 'Fuego', 'Fire');

-- Nebulica: fuego, roca vida:1 ataque:2 desc: RANGEDATTACK: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados.ESCAPE: Al final de tu turno, elige una de tus ubicaciones y transportate allí.

insert INTO card VALUES (4, 'Nebulica', 'Ataque a distancia: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. Huida: Al final de tu turno, elige una de tus ubicaciones y transportate allí.', 'Ranged attack: His attacks can jump over 1 unit in a straight line and hit distant targets. Escape: At the end of your turn, choose one of your locations and transport yourself there.', 12.00, '/images/CardDetail/card4.png');

insert INTO monster VALUES (4, 2, 1, 'Roca',  'Rock', 'Fuego', 'Fire');

-- nebulcoal fuego roca vida 2 ataque 4 RANGEDATTACK: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados.desc: SCARYSURPRISE(4): Hasta el principio de tu próximo turno, baja el ataque de cualquier legión dimential en 4 puntos.

INSERT into card VALUES (5, 'Nebulcoal', 'Ataque a distancia: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. Sorpresa aterradora (4): Hasta el principio de tu próximo turno, baja el ataque de cualquier legión dimential en 4 puntos.', 'Ranged attack: His attacks can jump over 1 unit in a straight line and hit distant targets. Scary surprise (4): Until the beginning of your next turn, lower the attack of any dimential legion by 4 points.', 20.00, '/images/CardDetail/card5.png');

insert INTO monster VALUES (5, 4, 2, 'Roca',  'Rock', 'Fuego', 'Fire');

-- nebulsmokar fuego roca vida 2 ataque 8 desc: RANGEDATTACK: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. EVANESCE: Evade el primer daño de ataque que reciba. En caso de no haber más dimentials en la línea, se aplica el daño de dominio

insert INTO card VALUES (6, 'Nebulsmokar', 'Ataque a distancia: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. Desvanecerse: Evade el primer daño de ataque que reciba. En caso de no haber más dimentials en la línea, se aplica el daño de dominio.', 'Ranged attack: His attacks can jump over 1 unit in a straight line and hit distant targets. Evanesce: Evade the first attack damage he receives. If there are no more dimentials in the line, the domain damage is applied.', 25.00, '/images/CardDetail/card6.png');

insert INTO monster VALUES (6, 8, 2, 'Roca',  'Rock', 'Fuego', 'Fire');

-- lizzar: fuego luz vida:2, ataque:2 desc: RANGEDATTACK: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. TARGETED DAMAGE (1): Al entrar en el campo de batalla, inflige a cualquier dimential 1 de daño.
insert INTO card VALUES (7, 'Lizzar', 'Ataque a distancia: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. Daño dirigido (1): Al entrar en el campo de batalla, inflige a cualquier dimential 1 de daño.', 'Ranged attack: His attacks can jump over 1 unit in a straight line and hit distant targets. Targeted damage (1): When entering the battlefield, inflict 1 damage to any dimential.', 15.00, '/images/CardDetail/card7.png');

insert INTO monster VALUES (7, 2, 2, 'Luz',  'Light', 'Fuego', 'Fire');

-- IGUANITXECO: vida: 3 attack: 4 tipo: fuego cielo RANGEDATTACK: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. TARGETED DAMAGE(2): Al entrar en el campo de batalla, inflige a cualquier unidad 2 de daño

INSERT into card VALUES (8, 'Iguanitxeco', 'Ataque a distancia: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. Daño dirigido (2): Al entrar en el campo de batalla, inflige a cualquier unidad 2 de daño.', 'Ranged attack: His attacks can jump over 1 unit in a straight line and hit distant targets. Targeted damage (2): When entering the battlefield, inflict 2 damage to any unit.', 18.00, '/images/CardDetail/card8.png');

insert INTO monster VALUES (8, 4, 3, 'Cielo',  'Sky', 'Fuego', 'Fire');

-- CITALFLAMA at:4 vida: 6 cielo fuego desc: RANGEDATTACK: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. TARGETED DAMAGE (4): Al entrar en el campo de batalla, inflige a cualquier dimential 4 de daño

INSERT into card VALUES (9, 'Citalflama', 'Ataque a distancia: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. Daño dirigido (4): Al entrar en el campo de batalla, inflige a cualquier dimential 4 de daño.', 'Ranged attack: His attacks can jump over 1 unit in a straight line and hit distant targets. Targeted damage (4): When entering the battlefield, inflict 4 damage to any dimential.', 30.00, '/images/CardDetail/card9.png');

insert INTO monster VALUES (9, 6, 4, 'Cielo',  'Sky', 'Fuego', 'Fire');

-- QUETZALIZARD vida 5 ataque 7 cielo fuego desc : RANGEDATTACK: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. TARGETED DAMAGE (1X7): Al entrar en el campo de batalla, inflige a cualquier dimential 1 de daño 7 veces
INSERT into card VALUES (10, 'Quetzalizard', 'Ataque a distancia: Sus ataques pueden saltar sobre 1 unidad en línea recta y golpear a objetivos alejados. Daño dirigido (1x7): Al entrar en el campo de batalla, inflige a cualquier dimential 1 de daño 7 veces.', 'Ranged attack: His attacks can jump over 1 unit in a straight line and hit distant targets. Targeted damage (1x7): When entering the battlefield, inflict 1 damage to any dimential 7 times.', 35.00, '/images/CardDetail/card10.png');

insert INTO monster VALUES (10, 7, 5, 'Cielo',  'Sky', 'Fuego', 'Fire');

--  Caldronis at3 vida 2 fuego roca CARDDRAW(1): Al entrar en el campo de batalla, el jugador roba 1 carta

INSERT into card VALUES (11, 'Caldronis', 'Robo de cartas (1): Al entrar en el campo de batalla, el jugador roba 1 carta.', 'Card draw (1): When entering the battlefield, the player draws 1 card.', 10.00, '/images/CardDetail/card11.png');

insert INTO monster VALUES (11, 3, 2, 'Roca',  'Rock', 'Fuego', 'Fire');

-- CALDERION at 5 vida 4 fuego roca CARDDRAW(2): Al entrar en el campo de batalla, el jugador roba 2 cartas

INSERT into card VALUES (12, 'Calderion', 'Robo de cartas (2): Al entrar en el campo de batalla, el jugador roba 2 cartas.', 'Card draw (2): When entering the battlefield, the player draws 2 cards.', 15.00, '/images/CardDetail/card12.png');

insert INTO monster VALUES (12, 5, 4, 'Roca',  'Rock', 'Fuego', 'Fire');

-- DRACALDRON at 8 vida 5 fuego roca CARDDRAW(3): Al entrar en el campo de batalla, el jugador roba 3 carta

insert into card VALUES (13, 'Dracaldron', 'Robo de cartas (3): Al entrar en el campo de batalla, el jugador roba 3 cartas.', 'Card draw (3): When entering the battlefield, the player draws 3 cards.', 20.00, '/images/CardDetail/card13.png');

insert INTO monster VALUES (13, 8, 5, 'Roca',  'Rock', 'Fuego', 'Fire');

-- FROGAN fuego roca vida 3 ataque 1 desc: "... Al parecer, los Frogan necesitan sumergirse en lava líquida para sobrevivir. A través de la piel absorben minerales y energias volcánicas que influyen en su correcto metabolismo y salud. Un Frogan alejado de la lava desarrollará una cornamenta frágil y delicada..." Extracto del D.I de Eron Vulk
insert INTO card VALUES (14, 'Frogan', 'Apparently, the Frogan need to be submerged in liquid lava to survive. Through the skin they absorb minerals and volcanic energies that influence their correct metabolism and health. A Frogan away from the lava will develop a fragile and delicate horn ''  Extract from Eron Vulks D.I., ... Al parecer, los Frogan necesitan sumergirse en lava líquida para sobrevivir. A través de la piel absorben minerales y energias volcánicas que influyen en su correcto metabolismo y salud. Un Frogan alejado de la lava desarrollará una cornamenta frágil y delicada Extracto del D.I de Eron Vulk', 10.00, '/images/CardDetail/card14.png');

insert INTO monster VALUES (14, 3, 1, 'Roca',  'Rock', 'Fuego', 'Fire');

-- BULLRAGA fuego roca vida 3 ataque 2 EMBESTIDA: Inflinge su poder de ataque a todos los dimentials que se encuentren en linea recta EMBESTIDA: Inflinge su poder de ataque a todos los dimentials que se encuentren en linea recta

insert INTO card VALUES (15, 'Bullraga', 'Charge: Inflicts his attack power on all dimentials in a straight line.', 'Charge: Inflicts his attack power on all dimentials in a straight line.', 12.00, '/images/CardDetail/card15.png');

insert INTO monster VALUES (15, 3, 2, 'Roca',  'Rock', 'Fuego', 'Fire');


-- TARVORONAUS fuego roca vida 5 ataque 4 desc: EMBESTIDA: Inflinge su poder de ataque a todos los dimentials que se encuentren en linea recta

insert INTO card VALUES (16, 'Tarvoronaus', 'Charge: Inflicts his attack power on all dimentials in a straight line.', 'Charge: Inflicts his attack power on all dimentials in a straight line.', 15.00, '/images/CardDetail/card16.png'); 

insert INTO monster VALUES (16, 5, 4, 'Roca',  'Rock', 'Fuego', 'Fire');

-- EMBERGANTE I at 3 vida 3 fuego roca dec: CALAM. MARKS Una vez por turno, puedes gastar 2 de energia para marcar a una de tus legiones afines. Las unidades marcadas adoptan la habilidad natural de la calamidad mientras siga con vida y la evolucionan conforme ella sube de nivel. Solo puede marcar la calam. de mayor nivel. DEVOUR(1/0): Cada vez que una legión es eliminada por esta unidad, se suma 1 de vida de forma permanente.

insert INTO card VALUES (17, 'Embergante I', 'Calamity Marks: Once per turn, you can spend 2 energy to mark one of your allied legions. The marked units adopt the natural ability of the calamity while it remains alive and evolve as it levels up. You can only mark the highest level calamity. Devour (1/0): Every time a legion is eliminated by this unit, 1 life is permanently added.', 'Calamity Marks: Once per turn, you can spend 2 energy to mark one of your allied legions. The marked units adopt the natural ability of the calamity while it remains alive and evolve as it levels up. You can only mark the highest level calamity. Devour (1/0): Every time a legion is eliminated by this unit, 1 life is permanently added.', 20.00, '/images/CardDetail/card17.png');

insert INTO monster VALUES (17, 3, 3, 'Roca',  'Rock', 'Fuego', 'Fire');

-- EMBERGANTE II at 4 vida 5 fuego roca desc Una vez por turno, puedes gastar 2 de energia para marcar a a una de tus legiones afines. Las unidades marcadas por la calamidad ganan su misma habilidad: DEVORAR(1/1): Cada vez que tu legión dimential elimina a otra legión, se suma 1 de vida y 1 de ataque de forma permanente

insert INTO card VALUES (18, 'Embergante II', 'Once per turn, you can spend 2 energy to mark one of your allied legions. The units marked by the calamity gain the same ability: DEVOUR (1/1): Every time your dimential legion eliminates another legion, 1 life and 1 attack are permanently added.', 'Once per turn, you can spend 2 energy to mark one of your allied legions. The units marked by the calamity gain the same ability: DEVOUR (1/1): Every time your dimential legion eliminates another legion, 1 life and 1 attack are permanently added.', 25.00, '/images/CardDetail/card18.png');

insert INTO monster VALUES (18, 4, 5, 'Roca',  'Rock', 'Fuego', 'Fire');

-- EMBERGANTE III at 6 vida 8 fuego roca desc CALAM. MARKS Una vez por turno, puedes gastar 2 de energia para marcar a una de tus legiones afines. Las unidades marcadas adoptan la habilidad naturañ de la calamidad mientras siga con vida y la evolucionan conforme ella sube de nivel. Solo puede marcar la calam. de mayor nivel. DEVOUR(2/1): Cada vez que una legión es eliminada por esta unidad, se suma 2 de vida y 1 de ataque de forma permanente.

insert INTO card VALUES (19, 'Embergante III', 'Calamity Marks: Once per turn, you can spend 2 energy to mark one of your allied legions. The marked units adopt the natural ability of the calamity while it remains alive and evolve as it levels up. You can only mark the highest level calamity. DEVOUR (2/1): Every time a legion is eliminated by this unit, 2 life and 1 attack are permanently added.', 'Calamity Marks: Once per turn, you can spend 2 energy to mark one of your allied legions. The marked units adopt the natural ability of the calamity while it remains alive and evolve as it levels up. You can only mark the highest level calamity. DEVOUR (2/1): Every time a legion is eliminated by this unit, 2 life and 1 attack are permanently added.', 30.00, '/images/CardDetail/card19.png');

insert INTO monster VALUES (19, 6, 8, 'Roca',  'Rock', 'Fuego', 'Fire');

-- EMBERGANTE IV at 7 vida 11 CALAM. MARKS Una vez por turno, puedes gastar 2 de energia para marcar a una de tus legiones afines. Las unidades marcadas adoptan la habilidad naturañ de la calamidad mientras siga con vida y la evolucionan conforme ella sube de nivel. Solo puede marcar la calam. de mayor nivel. DEVOUR(2/2): Cada vez que una legión es eliminada por esta unidad, se suma 2 de vida y 2 de ataque de forma permanente.
insert INTO card VALUES (20, 'Embergante IV', 'Calamity Marks: Once per turn, you can spend 2 energy to mark one of your allied legions. The marked units adopt the natural ability of the calamity while it remains alive and evolve as it levels up. You can only mark the highest level calamity. DEVOUR (2/2): Every time a legion is eliminated by this unit, 2 life and 2 attack are permanently added.', 'Calamity Marks: Once per turn, you can spend 2 energy to mark one of your allied legions. The marked units adopt the natural ability of the calamity while it remains alive and evolve as it levels up. You can only mark the highest level calamity. DEVOUR (2/2): Every time a legion is eliminated by this unit, 2 life and 2 attack are permanently added.', 35.00, '/images/CardDetail/card20.png');

insert INTO monster VALUES (20, 7, 11, 'Roca',  'Rock', 'Fuego', 'Fire');

-- ahora los spells
-- los spells no tienen tipos, ataque y defensa, solo mana
-- RED DRAGON CLAWS mana 5 desc Selecciona a una de tus legiones y equipale esta transformación. Las características adicionales se añaden permanentemente, incluso si la legión evoluciona.

insert INTO card VALUES (21, 'Red Dragon Claws', 'Select one of your legions and equip it with this transformation. The additional characteristics are added permanently, even if the legion evolves.', 'Select one of your legions and equip it with this transformation. The additional characteristics are added permanently, even if the legion evolves.', 20.00, '/images/CardDetail/card21.png');

insert INTO spell VALUES (21, 5);

-- Elemental Lava SPA mana:5 desc:Elige una de tus posiciones e invoca de forma especial a una legión Elemental de tipo Roca/Fuego LV2, con estadistidicas 1/1. Invoca a su izquierda y derecha a otras dos legiones con las mismas estadísticas 

insert INTO card VALUES (22, 'Elemental Lava SPA', 'Choose one of your positions and special summon a Rock/Fire Elemental legion LV2, with statistics 1/1. Summon to his left and right two other legions with the same statistics.', 'Choose one of your positions and special summon a Rock/Fire Elemental legion LV2, with statistics 1/1. Summon to his left and right two other legions with the same statistics.', 20.00, '/images/CardDetail/card22.png');

insert INTO spell VALUES (22, 5);

-- CREEPY FIRE BOMB mana:4 desc: Selecciona una zona del campo de batalla. Al principio del 3º turno tras haber activado esta carta, infligirá el daño a cualquier unidad que lo ocupe. En caso de que no haya unidad en la zona, se aplicarán puntos de dominio.

insert INTO card VALUES (23, 'Creepy Fire Bomb', 'Select an area of the battlefield. At the beginning of the 3rd turn after activating this card, it will inflict damage on any unit that occupies it. If there is no unit in the area, domain points will be applied.', 'Select an area of the battlefield. At the beginning of the 3rd turn after activating this card, it will inflict damage on any unit that occupies it. If there is no unit in the area, domain points will be applied.', 15.00, '/images/CardDetail/card23.png');

insert INTO spell VALUES (23, 4);

-- Hidden LAVA GUARD mana: 6 desc: Elige una de tus legiones dimential y sumales 6 de armadura. La armadura funciona como puntos adicionales a la estadística de vida, consumiendose primero en su lugar. La armadura de este hechizo desaparece al principio del siguiente turno

insert INTO card VALUES (24, 'Hidden Lava Guard', 'Choose one of your dimential legions and add 6 armor to them. The armor works as additional points to the life statistic, consuming first in its place. The armor of this spell disappears at the beginning of the next turn.', 'Choose one of your dimential legions and add 6 armor to them. The armor works as additional points to the life statistic, consuming first in its place. The armor of this spell disappears at the beginning of the next turn.', 25.00, '/images/CardDetail/card24.png');

insert INTO spell VALUES (24, 6);

-- BURN SCUM BREATH mana: 12 desc:Elimina TODOS los dimentials de Lv4 e inferior del campo de batalla

insert INTO card VALUES (25, 'Burn Scum Breath', 'Eliminate ALL dimentials of Lv4 and lower from the battlefield.', 'Eliminate ALL dimentials of Lv4 and lower from the battlefield.', 30.00, '/images/CardDetail/card25.png');

insert INTO spell VALUES (25, 12);