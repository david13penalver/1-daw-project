package com.dimentials.shop.unit.domain.service;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.service.CardService;
import com.dimentials.shop.domain.service.impl.CardServiceImpl;
import com.dimentials.shop.mock.repository.CardRepositoryMock;
import com.dimentials.shop.persistence.repository.CardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardServiceImplTest {

    private final CardRepository cardRepositoryMock = new CardRepositoryMock();
    private final CardService cardService = new CardServiceImpl(cardRepositoryMock);

    @Test
    @DisplayName("The methods findAll() returns all the cards")
    void findAllReturnsAllCards() {
        List<Card> expectedList = List.of(
                new Card(1, "Nebulsmokar", "Monstruo"),
                new Card(2, "Lizzar", "Monstruito"),
                new Card(3, "Frogan", "Monstruitillo")
        );

        List<Card> cardList = cardRepositoryMock.findAll();

        assertEquals(expectedList, cardList);
    }

    @Test
    @DisplayName("The methods findById(id) returns the card inserted at the parameter")
    void findByIdReturnsTheCardDemandedAtTheParam() {
        List<Card> expectedList = List.of(
                new Card(1, "Nebulsmokar", "Monstruo"),
                new Card(2, "Lizzar", "Monstruito"),
                new Card(3, "Frogan", "Monstruitillo")
        );

        Card cardExpected1 = expectedList.get(0);
        Card cardExpected2 = expectedList.get(1);
        Card cardExpected3 = expectedList.get(2);

        Card card1 = cardRepositoryMock.findById(1);
        Card card2 = cardRepositoryMock.findById(2);
        Card card3 = cardRepositoryMock.findById(3);

        assertAll(
                () -> assertEquals(cardExpected1, card1),
                () -> assertEquals(cardExpected2, card2),
                () -> assertEquals(cardExpected3, card3)
        );
    }
}
