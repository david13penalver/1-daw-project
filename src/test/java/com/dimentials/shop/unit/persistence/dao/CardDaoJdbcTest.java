package com.dimentials.shop.unit.persistence.dao;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;
import com.dimentials.shop.persistence.dao.impl.jdbc.CardDaoJdbc;
import com.dimentials.shop.persistence.dao.impl.jdbc.rawSql.DatabaseConnection;
import org.junit.jupiter.api.*;
import org.springframework.context.i18n.LocaleContextHolder;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardDaoJdbcTest {
    private final CardDao cardDao = new CardDaoJdbc();
    private static final DatabaseConnection connection = DatabaseConnection.getInstance();
    public final List<CardEntity> expectedLlibreList = new ArrayList<>(
            List.of(
                    new CardEntity(1, "Lavacus", "Description", new BigDecimal(7), "image"),
                    new CardEntity(2, "Pyromagmus", "Description", new BigDecimal(7), "image")
            )
    );
    @BeforeAll
    static void setup() throws SQLException {
        connection.executeScript("schema.sql");
        connection.executeScript("data.sql");
        connection.getConnection().setAutoCommit(false);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.getConnection().rollback();
    }

    @Nested
    class FindTests {
        @Test
        void findAll_shouldReturnAllCards() {
            List<CardEntity> result = cardDao.findAll();
            assertEquals(expectedLlibreList, result);
        }

        @Test
        void findById_shouldReturnCard() {
            CardEntity result = cardDao.findById(1);
            assertEquals(expectedLlibreList.get(0), result);
        }
    }

    @Nested
    class InsertionTests {
        @Test
        @Disabled
        void addMonster_shouldInsertMonster() {
            MonsterEntity monster = new MonsterEntity(null, "Name", "Description_es", "Description_en", new BigDecimal(7), "image", 1, 1, "mainType_es", "mainType_en", "secondaryType_es", "secondaryType_en");
            cardDao.addMonster(monster);

            Locale currentLocale = LocaleContextHolder.getLocale();
            String language = currentLocale.getLanguage();
            monster.setDescription("Description_" + language);

            CardEntity result = cardDao.findById(3);
            assertAll(
                    () -> assertEquals(monster.getName(), result.getName()),
                    () -> assertEquals(monster.getDescription(), result.getDescription()),
                    () -> assertEquals(monster.getPrice(), result.getPrice()),
                    () -> assertEquals(monster.getImgPath(), result.getImgPath())
            );
        }

        @Test
        @Disabled
        void addSpell_shouldInsertSpell() {
            SpellEntity spell = new SpellEntity(null, "Name", "Description_es", "Description_en", new BigDecimal(7), "image", 1);
            cardDao.addSpell(spell);

            Locale currentLocale = LocaleContextHolder.getLocale();
            String language = currentLocale.getLanguage();
            spell.setDescription("Description_" + language);

            CardEntity result = cardDao.findById(3);
            assertAll(
                    () -> assertEquals(spell.getName(), result.getName()),
                    () -> assertEquals(spell.getDescription(), result.getDescription()),
                    () -> assertEquals(spell.getPrice(), result.getPrice()),
                    () -> assertEquals(spell.getImgPath(), result.getImgPath())
            );
        }
    }

    @Nested
    class AlterationTests {
        @Test
        @Disabled
        void updateMonster_shouldUpdateMonster() {
            MonsterEntity monster = new MonsterEntity(1, "Name", "Description_es.", "Description_en", new BigDecimal(7), "image", 1, 1, "mainType_es", "mainType_en", "secondaryType_es", "secondaryType_en");
            cardDao.updateMonster(monster);
            expectedLlibreList.add(monster);
            CardEntity result = cardDao.findById(1);
            assertEquals(monster, result);
        }

        @Test
        @Disabled
        void updateSpell_shouldUpdateSpell() {
            SpellEntity spell = new SpellEntity(null, "Lavacus", "Escudo (1): Genera 1 de armadura al final de cada uno de tus turnos. La armadura se suma a la vida y se consume cuando tu legión dimensional es atacada. La armadura de esta habilidad es acumulable y la que no es consumida permanece incluso cuando la legión evoluciona.", new BigDecimal(7), "image", 1);
            cardDao.updateSpell(spell);
            CardEntity result = cardDao.findById(1);
            assertEquals(spell, result);
        }
    }
    @Nested
    class DeletionTests {
        @Test
        @Disabled
        void deleteCard_shouldDeleteCard() {
            cardDao.deleteCard(1);
            List<CardEntity> result = cardDao.findAll();
            assertEquals(expectedLlibreList.size() - 1, result.size());
        }
    }


}
