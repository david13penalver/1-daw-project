package com.dimentials.shop.unit.service;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.service.CardService;
import com.dimentials.shop.domain.service.impl.CardServiceImpl;
import com.dimentials.shop.mock.repository.CardRepositoryMock;
import com.dimentials.shop.persistence.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardServiceImplTest {

    private final CardRepository cardRepositoryMock = new CardRepositoryMock();
    private final CardService cardService = new CardServiceImpl(cardRepositoryMock);

    private List<Card> expectedList;
    @BeforeEach
    void setUp() {
        expectedList = new ArrayList<>(
                List.of(
                        new Card(1, "Nebulsmokar", "Monstruo", "Nebulsmokar.jpg"),
                        new Card(2, "Lizzar", "Monstruito", "Lizzar.jpg"),
                        new Card(3, "Frogan", "Monstruitillo", "Frogan.jpg")
                )
        );
    }

    @Test
    @DisplayName("The methods findAll() returns all the cards")
    void findAllReturnsAllCards() {
        List<Card> cardList = cardService.findAll();

        assertEquals(expectedList, cardList);
    }

    @Test
    @DisplayName("The methods findById(1) returns the card inserted at the parameter")
    void findById1ReturnsTheBookWithTheFirstId() {


        Card cardExpected1 = expectedList.get(0);

        Card card1 = cardService.findById(1);

        assertEquals(cardExpected1, card1);
    }

    @Test
    @DisplayName("The methods findById(2) returns the card inserted at the parameter")
    void findById2ReturnsTheBookWithTheSecondId() {
        Card cardExpected2 = expectedList.get(1);

        Card card2 = cardService.findById(2);

        assertEquals(cardExpected2, card2);
    }

    @Test
    @DisplayName("The methods findById(id) not found returns null")
    void findByIdNotFoundReturnsNull() {
        Card card3 = cardService.findById(5);

        assertNull(card3);
    }


}
