package com.dimentials.shop.unit.persistence.repository;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.mock.repository.CardDaoMock;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.repository.CardRepository;
import com.dimentials.shop.persistence.repository.impl.CardRepositoryImpl;
import com.dimentials.shop.persistence.repository.mapper.CardMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CardRepositoryImplTest {
    private final CardDao cardDao = new CardDaoMock();
    private final CardRepository cardRepository = new CardRepositoryImpl(cardDao);

    private List<Card> expectedList;
    @BeforeEach
    void setUp() {
        expectedList = List.of(
                new Card(1, "Nebulsmokar", "Monstruo", "Nebulsmokar.jpg"),
                new Card(2, "Lizzar", "Monstruito", "Lizzar.jpg"),
                new Card(3, "Frogan", "Monstruitillo", "Frogan.jpg")
        );
    }

    @Test
    @DisplayName("The methods findAll() returns all the cards")
    void findAllReturnsAllCards2() {
        List<Card> cardList = CardMapper.toCardList(cardDao.findAll());

        assertEquals(expectedList, cardList);
    }

    @Test
    @DisplayName("The methods findAll() returns all the cards")
    void findAllReturnsAllCards() {
        List<Card> cardList = CardMapper.toCardList(cardDao.findAll());

        assertEquals(expectedList, cardList);
    }

    @Nested
    class findById {
        @Test
        @DisplayName("The methods findById(1) returns the card inserted at the parameter")
        void findById1ReturnsTheBookWithTheFirstId() {
            Card cardExpected1 = expectedList.get(0);

            Card card1 = CardMapper.toCard(cardDao.findById(1));

            assertEquals(cardExpected1, card1);
        }

        @Test
        @DisplayName("The methods findById(2) returns the card inserted at the parameter")
        void findById2ReturnsTheBookWithTheSecondId() {
            Card cardExpected2 = expectedList.get(1);

            Card card2 = CardMapper.toCard(cardDao.findById(2));

            assertEquals(cardExpected2, card2);
        }

        @Test
        @DisplayName("The methods findById(id) not found returns null")
        void findByIdNotFoundReturnsNull() {
            Card card3 = CardMapper.toCard(cardDao.findById(10));

            assertNull(card3);
        }
    }
}
