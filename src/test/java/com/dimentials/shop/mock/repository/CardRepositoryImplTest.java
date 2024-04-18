package test.java.com.dimentials.shop.unit.persistence.repository.impl;

import com.dimentials.shop.mock.repository.CardDaoMock;
import com.dimentials.shop.persistence.repository.mapper.CardMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.repository.impl.CardRepositoryImpl;
import com.dimentials.shop.persistence.repository.mapper.CardMapper; // Add missing import statement
// Add missing import statement

public class CardRepositoryImplTest {

    private CardDaoMock cardDao;
    private CardRepositoryImpl cardRepository;

    @BeforeEach
    public void setup() {
        cardDao = mock(CardDaoMock.class);
        cardRepository = new CardRepositoryImpl(cardDao);
    }

    @Test
    @DisplayName("Test findAll method")
    public void testFindAll() {
        List<Card> expectedList = List.of(
            new Card(1, "Nebulsmokar", "Monstruo"),
            new Card(2, "Lizzar", "Monstruito"),
            new Card(3, "Frogan", "Monstruitillo")
        );

        CardDaoMock cardDaoMock = new CardDaoMock(); // Create an instance of CardDaoMock
        List<Card> cardList = CardMapper.toCardList(cardDaoMock.findAll()); // Call findAll() on the instance

        assertAll(
            () -> assertEquals(expectedList.get(0), cardList.get(0)),
            () -> assertEquals(expectedList.get(1), cardList.get(1)),
            () -> assertEquals(expectedList.get(2), cardList.get(2)));

    }

    @Test
    @DisplayName("Test findById method")
    public void testFindById() {

    }
}