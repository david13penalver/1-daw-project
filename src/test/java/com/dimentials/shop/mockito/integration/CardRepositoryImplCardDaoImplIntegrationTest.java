package com.dimentials.shop.mockito.integration;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.repository.CardRepository;
import com.dimentials.shop.persistence.repository.impl.CardRepositoryImpl;
import com.dimentials.shop.persistence.repository.mapper.CardMapper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardRepositoryImplCardDaoImplIntegrationTest {

    private final CardDao cardDaoMock = mock(CardDao.class);
    private final CardRepository cardRepository = new CardRepositoryImpl(cardDaoMock);
    private final CardEntity card1 = new CardEntity(1, "Card1", "Description", new BigDecimal(10.50), "/images/card1.jpg");
    private final CardEntity card2 = new CardEntity(2, "Card2", "Description", new BigDecimal(20.50), "/images/card2.jpg");
    private final List<CardEntity> cardList = List.of(card1, card2);

    @Nested
    class FindCardByIdTests {
        // Test cases for findCardById
        @Test
        void givenExistingCardId1_shouldReturnCard1() {
            // Arrange
            when(cardDaoMock.findById(1)).thenReturn(card1);
            // Act
            Card cardResult = cardRepository.findById(1);
            // Assert
            assertEquals(CardMapper.toCard(card1), cardResult);
        }
        @Test
        void givenExistingCardId2_shouldReturnCard2() {
            // Arrange
            when(cardDaoMock.findById(2)).thenReturn(card2);
            // Act
            Card cardResult = cardRepository.findById(2);
            // Assert
            assertEquals(CardMapper.toCard(card2), cardResult);
        }
        @Test
        void givenNonExistingCardId_shouldReturnNull() {
            // Arrange
            when(cardDaoMock.findById(3)).thenReturn(null);
            // Act
            Card cardResult = cardRepository.findById(3);
            // Assert
            assertEquals(CardMapper.toCard(null), cardResult);
        }
    }
    @Nested
    class FindAllCardsTests {
        // Test cases for findCardByCategoryId
    }
}
