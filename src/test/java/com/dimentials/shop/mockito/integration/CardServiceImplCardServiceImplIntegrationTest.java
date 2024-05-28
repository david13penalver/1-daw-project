package com.dimentials.shop.mockito.integration;
import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.service.CardService;
import com.dimentials.shop.domain.service.impl.CardServiceImpl;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.repository.CardRepository;
import com.dimentials.shop.persistence.repository.impl.CardRepositoryImpl;
import com.dimentials.shop.persistence.repository.mapper.CardMapper;
import org.junit.jupiter.api.DisplayName;
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
public class CardServiceImplCardServiceImplIntegrationTest {
    private final CardRepository cardRepositoryMock = mock(CardRepository.class);
    private final CardService cardService = new CardServiceImpl(cardRepositoryMock);
    private final CardEntity card1 = new CardEntity(1, "Card1", "Description", new BigDecimal(10.50), "/images/card1.jpg");
    private final CardEntity card2 = new CardEntity(2, "Card2", "Description", new BigDecimal(20.50), "/images/card2.jpg");
    private final List<CardEntity> cardList = List.of(card1, card2);
    @Nested
    class FindByIdTests {
        // Test cases for findAll
        @Test
        @DisplayName("FindById: returns the card with the id 1")
        void givenExistingCardId1_shouldReturnCard1() {
            // Arrange
            when(cardRepositoryMock.findById(1)).thenReturn(CardMapper.toCard(card1));

            // Act
            Card cardResult = cardService.findById(1);
            // Assert
            assertEquals(CardMapper.toCard(card1), cardResult);
        }

        @Test
        @DisplayName("FindById: returns the card with the id 2")
        void givenExistingCardId2_shouldReturnCard2() {
            // Arrange
            when(cardRepositoryMock.findById(2)).thenReturn(CardMapper.toCard(card2));
            // Act
            Card cardResult = cardService.findById(2);
            // Assert
            assertEquals(CardMapper.toCard(card2), cardResult);
        }
        @Test
        @DisplayName("FindById: returns null when the card with the id 3 does not exist")
        void givenNonExistingCardId_shouldReturnNull() {
            // Arrange
            when(cardRepositoryMock.findById(3)).thenReturn(null);
            // Act
            Card cardResult = cardService.findById(3);
            // Assert
            assertEquals(CardMapper.toCard(null), cardResult);
        }
    }
    // Test cases for findCardById
    @Nested
    class FindAllTests {
        @Test
        @DisplayName("FindAll: returns all the cards")
        void shouldReturnAllCards() {
            // Arrange
            when(cardRepositoryMock.findAll()).thenReturn(CardMapper.toCardList(cardList));
            // Act
            List<Card> cardResult = cardService.findAll();
            // Assert
            assertEquals(CardMapper.toCardList(cardList), cardResult);
        }
        @Test
        @DisplayName("FindAll: returns empty list when no cards exist")
        void givenNoCards_shouldReturnEmptyList() {
            // Arrange
            when(cardRepositoryMock.findAll()).thenReturn(List.of());
            // Act
            List<Card> cardResult = cardService.findAll();
            // Assert
            assertEquals(CardMapper.toCardList(List.of()), cardResult);
        }
        }

    }


