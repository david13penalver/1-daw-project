package com.dimentials.shop.unit.persistence.dao;

import com.dimentials.shop.common.exception.QueryBuilderSQLException;
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

import static org.junit.jupiter.api.Assertions.*;

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
        @DisplayName("findAll should return all cards")
        void findAll_shouldReturnAllCards() {
            List<CardEntity> result = cardDao.findAll();
            assertEquals(expectedLlibreList, result);
        }

        @Test
        @DisplayName("findById(1) should return card(1)")
        void findById_shouldReturnCard() {
            CardEntity result = cardDao.findById(1);
            assertEquals(expectedLlibreList.get(0), result);
        }
        @Test
        @DisplayName("findById(2) should return card(2)")
        void findById_shouldReturnCard2() {
            CardEntity result = cardDao.findById(2);
            assertEquals(expectedLlibreList.get(1), result);
        }
        @Test
        @DisplayName("findById(3) should return null")
        void findById_shouldReturnCard3() {
            assertNull(cardDao.findById(999));
        }
    }

    @Nested
    class InsertionTests {
        @Test
        @DisplayName("addMonster should insert a monster")
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
        @DisplayName("addMonster should throw an exception")
        void addMonster_shouldThrowException() {
            MonsterEntity monster = new MonsterEntity(null, "Name", "Description_es", new BigDecimal(7), "image", 1, 1, "mainType_es", "secondaryType_es");
            assertThrows(QueryBuilderSQLException.class, () -> cardDao.addMonster(monster));
        }

        @Test
        @DisplayName("addSpell should insert a spell")
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
        @Test
        @DisplayName("addSpell should throw an exception")
        void addSpell_shouldThrowException() {
            SpellEntity spell = new SpellEntity();
            assertThrows(QueryBuilderSQLException.class, () -> cardDao.addSpell(spell));
        }
    }

    @Nested
    class UpdateTests {
        @Test
        @DisplayName("updateMonster should update a monster")
        void updateMonster_shouldUpdateMonster() {
            MonsterEntity monster = new MonsterEntity(1, "Name", "Description_es", "Description_en", new BigDecimal(7), "image", 1, 1, "mainType_es", "mainType_en", "secondaryType_es", "secondaryType_en");
            cardDao.updateMonster(monster);

            Locale currentLocale = LocaleContextHolder.getLocale();
            String language = currentLocale.getLanguage();
            monster.setDescription("Description_" + language);

            CardEntity result = cardDao.findById(1);
            assertAll(
                    () -> assertEquals(monster.getName(), result.getName()),
                    () -> assertEquals(monster.getDescription(), result.getDescription()),
                    () -> assertEquals(monster.getPrice(), result.getPrice()),
                    () -> assertEquals(monster.getImgPath(), result.getImgPath())
            );
        }
        @Test
        @DisplayName("updateMonster should throw an exception")
        void updateMonster_shouldThrowException() {
            MonsterEntity monster = new MonsterEntity(10, "Name", "Description_es", new BigDecimal(7), "image", 1, 1, "mainType_es", "secondaryType_es");
            assertThrows(QueryBuilderSQLException.class, () -> cardDao.updateMonster(monster));
        }

        @Test
        @DisplayName("updateSpell should update a spell")
        void updateSpell_shouldUpdateSpell() {
            SpellEntity spell = new SpellEntity(1, "Name", "Description_es", "Description_en", new BigDecimal(7), "image", 1);
            cardDao.updateSpell(spell);

            Locale currentLocale = LocaleContextHolder.getLocale();
            String language = currentLocale.getLanguage();
            spell.setDescription("Description_" + language);

            CardEntity result = cardDao.findById(1);
            assertAll(
                    () -> assertEquals(spell.getName(), result.getName()),
                    () -> assertEquals(spell.getDescription(), result.getDescription()),
                    () -> assertEquals(spell.getPrice(), result.getPrice()),
                    () -> assertEquals(spell.getImgPath(), result.getImgPath())
            );
        }
        @Test
        @DisplayName("updateSpell should throw an exception")
        void updateSpell_shouldThrowException() {
            SpellEntity spell = new SpellEntity(10, "Name", "Description_es", new BigDecimal(7), "image", 1);
            assertThrows(QueryBuilderSQLException.class, () -> cardDao.updateSpell(spell));
        }
    }
    @Nested
    class DeletionTests {
        @Test
        @DisplayName("deleteCard should delete a card")
        void deleteCard_shouldDeleteCard() {
            cardDao.deleteCard(1);
            List<CardEntity> result = cardDao.findAll();
            assertEquals(expectedLlibreList.size() - 1, result.size());
        }
        @Test
        @DisplayName("deleteCard should throw an exception")
        void deleteCard_shouldThrowException() {
            assertThrows(QueryBuilderSQLException.class, () -> cardDao.deleteCard(10));
        }
    }


}
