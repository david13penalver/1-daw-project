package com.dimentials.shop.mockito.integration;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.domain.service.CardService;
import com.dimentials.shop.domain.service.impl.CardServiceImpl;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CardServiceImplCardDaoImplIntegrationTest {
    private final CardDao cardDao = new CardDaoJdbc();
    private final CardRepository cardRepository = new CardRepositoryImpl(cardDao);
    private final CardService cardService = new CardServiceImpl(cardRepository);
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
            assertEquals(CardMapper.toCard(expectedLlibreList.get(0)), cardService.findById(1));
        }
        @Test
        @DisplayName("FindById: returns the card with the id 2")
        void givenExistingCardId2_shouldReturnCard2() {
            assertEquals(CardMapper.toCard(expectedLlibreList.get(1)), cardService.findById(2));
        }

        @Test
        @DisplayName("FindById: returns null when the card with the id 3 does not exist")
        void givenNonExistingCardId_shouldReturnNull() {
            // Act
            Card cardResult = cardService.findById(3);
            // Assert
            assertNull(cardResult);
        }
    }
    @Nested
    class FindAllCardsTests {
        @Test
        @DisplayName("FindAll: returns all cards")
        void givenExistingCards_shouldReturnAllCards() {
            assertEquals(CardMapper.toCardList(expectedLlibreList), cardService.findAll());
        }
    }
}
