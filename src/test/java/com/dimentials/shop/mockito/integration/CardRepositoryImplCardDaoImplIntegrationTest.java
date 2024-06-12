package com.dimentials.shop.mockito.integration;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.impl.jdbc.CardDaoJdbc;
import com.dimentials.shop.persistence.dao.impl.jdbc.rawSql.DatabaseConnection;
import com.dimentials.shop.persistence.dao.impl.jdbc.rawSql.RawSql;
import com.dimentials.shop.persistence.repository.CardRepository;
import com.dimentials.shop.persistence.repository.impl.CardRepositoryImpl;
import com.dimentials.shop.persistence.repository.mapper.CardMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CardRepositoryImplCardDaoImplIntegrationTest {

    private final CardDao cardDao = new CardDaoJdbc();
    private final CardRepository cardRepository = new CardRepositoryImpl(cardDao);
    private final CardEntity card1 = new CardEntity(1, "Card1", "Description", new BigDecimal(10.50), "/images/card1.jpg");
    private final CardEntity card2 = new CardEntity(2, "Card2", "Description", new BigDecimal(20.50), "/images/card2.jpg");
    public final List<CardEntity> expectedLlibreList = new ArrayList<>(
            List.of(
                    new CardEntity(1, "Lavacus", "Description", new BigDecimal(7), "image"),
                    new CardEntity(2, "Pyromagmus", "Description", new BigDecimal(7), "image")
            )
    );

    private static final DatabaseConnection connection = DatabaseConnection.getInstance();
    private static boolean initialized = false;
    @BeforeAll
    static void setup() throws SQLException {
        if (!initialized) {
            connection.executeScript("schema.sql");
            connection.executeScript("data.sql");
            connection.getConnection().setAutoCommit(false);
            initialized = true;
        }
    }

    @AfterEach
    void tearDown() throws SQLException {
        System.out.println("Rolling back");
        RawSql.rollback();
    }

    @Nested
    class FindCardByIdTests {
        // Test cases for findCardById
        @Test
        @DisplayName("FindById: returns the card with the id 1")
        void givenExistingCardId1_shouldReturnCard1() {
            assertEquals(CardMapper.toCard(expectedLlibreList.get(0)), cardRepository.findById(1));
        }
        @Test
        @DisplayName("FindById: returns the card with the id 2")
        void givenExistingCardId2_shouldReturnCard2() {
            assertEquals(CardMapper.toCard(expectedLlibreList.get(1)), cardRepository.findById(2));
        }

        @Test
        @DisplayName("FindById: returns null when the card with the id 3 does not exist")
        void givenNonExistingCardId_shouldReturnNull() {
            // Act
            Card cardResult = cardRepository.findById(3);
            // Assert
            assertNull(cardResult);
        }
    }
    @Nested
    class FindAllCardsTests {
        @Test
        @DisplayName("FindAll: returns all cards")
        void givenExistingCards_shouldReturnAllCards() {
            assertEquals(CardMapper.toCardList(expectedLlibreList), cardRepository.findAll());
        }
    }

//    @Nested
//    class AddingCards {
//        @Test
//        @DisplayName("AddMonster: adds a new monster to the list of cards")
//        void theMethodAddMonsterAddsANewMonsterToTheList() {
//            // Arrange
//            MonsterEntity monster = new MonsterEntity(null, "Name", "Description_es", new BigDecimal(7), "image", 1, 1, "mainType_es", "secondaryType_es");
//            // Act
//            cardDao.addMonster(monster);
//            // Assert
//            CardEntity result = cardDao.findById(3);
//            assertNotNull(result);
//            assertEquals(monster.getName(), result.getName());
//            assertEquals(monster.getDescription(), result.getDescription());
//            assertEquals(monster.getPrice(), result.getPrice());
//            assertEquals(monster.getImgPath(), result.getImgPath());
//        }
//
//        @Test
//        @DisplayName("AddSpell: adds a new spell to the list of cards")
//        void theMethodAddSpellAddsANewSpellToTheList() {
//            // Arrange
//            Spell spell = new Spell(3, "Name", "Description_es",  new BigDecimal(10), "path", 5);
//            // Act
//            cardRepository.addSpell(spell);
//            // Assert
//            verify(cardDao, times(1)).addSpell(any());
//        }
//    }
//
//    @Nested
//    class Updatingtests {
//        @Test
//        @DisplayName("UpdateMonster: updates the monster in the list of cards")
//        void theMethodUpdateMonsterUpdatesTheMonsterInTheList() {
//            // Arrange
//            Monster monster = new Monster();
//            // Act
//            cardRepository.updateMonster(monster);
//            // Assert
//            verify(cardDao, times(1)).updateMonster(any());
//        }
//
//        @Test
//        @DisplayName("UpdateSpell: updates the spell in the list of cards")
//        void theMethodUpdateSpellUpdatesTheSpellInTheList() {
//            // Arrange
//            Spell spell = new Spell();
//            // Act
//            cardRepository.updateSpell(spell);
//            // Assert
//            verify(cardDao, times(1)).updateSpell(any());
//        }
//
//    }
//    @Nested
//    class DeletingTests {
//        @Test
//        @DisplayName("DeleteCard: deletes the card of the same id")
//        void theMethodDeleteCardDeletesTheCardInTheList() {
//            // Arrange
//            Integer id = 1;
//            // Act
//            cardRepository.deleteCard(id);
//            // Assert
//            verify(cardRepository, times(1)).deleteCard(any());
//        }
//    }
}
