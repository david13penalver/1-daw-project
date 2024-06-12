package com.dimentials.shop.mockito.integration;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class CardServiceImplCardRepositoryImplIntegrationTest {
    private final CardDao cardDaoMock = mock(CardDao.class);
    private final CardRepository cardRepository = new CardRepositoryImpl(cardDaoMock);
    private final CardService cardService = new CardServiceImpl(cardRepository);
    private final CardEntity card1 = new CardEntity(1, "Card1", "Description", new BigDecimal(10.50), "/images/card1.jpg");
    private final CardEntity card2 = new CardEntity(2, "Card2", "Description", new BigDecimal(20.50), "/images/card2.jpg");
    private final List<CardEntity> cardList = List.of(card1, card2);

    @Nested
    class FindCardByIdTests {
        // Test cases for findCardById
        @Test
        @DisplayName("FindById: returns the card with the id 1")
        void givenExistingCardId1_shouldReturnCard1() {
            // Arrange
            when(cardDaoMock.findById(1)).thenReturn(card1);
            // Act
            Card cardResult = cardService.findById(1);
            // Assert
            assertEquals(CardMapper.toCard(card1), cardResult);
        }
        @Test
        @DisplayName("FindById: returns the card with the id 2")
        void givenExistingCardId2_shouldReturnCard2() {
            // Arrange
            when(cardDaoMock.findById(2)).thenReturn(card2);
            // Act
            Card cardResult = cardService.findById(2);
            // Assert
            assertEquals(CardMapper.toCard(card2), cardResult);
        }
        @Test
        @DisplayName("FindById: returns null when the card with the id 3 does not exist")
        void givenNonExistingCardId_shouldReturnNull() {
            // Arrange
            when(cardDaoMock.findById(3)).thenReturn(null);
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
            // Arrange
            when(cardDaoMock.findAll()).thenReturn(cardList);
            // Act
            List<Card> cardResult = cardService.findAll();
            // Assert
            assertEquals(CardMapper.toCardList(cardList), cardResult);
        }
        @Test
        @DisplayName("FindAll: returns empty list when no cards exist")
        void givenNoCards_shouldReturnEmptyList() {
            // Arrange
            when(cardDaoMock.findAll()).thenReturn(List.of());
            // Act
            List<Card> cardResult = cardService.findAll();
            // Assert
            assertEquals(CardMapper.toCardList(List.of()), cardResult);
        }
    }

    @Nested
    class AddingCards {
        @Test
        @DisplayName("AddMonster: adds a new monster to the list of cards")
        void theMethodAddMonsterAddsANewMonsterToTheList() {
            // Arrange
            Monster monster = new Monster();
            // Act
            cardRepository.addMonster(monster);
            // Assert
            verify(cardDaoMock, times(1)).addMonster(any());
        }

        @Test
        @DisplayName("AddSpell: adds a new spell to the list of cards")
        void theMethodAddSpellAddsANewSpellToTheList() {
            // Arrange
            Spell spell = new Spell();
            // Act
            cardRepository.addSpell(spell);
            // Assert
            verify(cardDaoMock, times(1)).addSpell(any());
        }
    }

    @Nested
    class Updatingtests {
        @Test
        @DisplayName("UpdateMonster: updates the monster in the list of cards")
        void theMethodUpdateMonsterUpdatesTheMonsterInTheList() {
            // Arrange
            Monster monster = new Monster();
            // Act
            cardService.updateMonster(monster);
            // Assert
            verify(cardDaoMock, times(1)).updateMonster(any());
        }

        @Test
        @DisplayName("UpdateSpell: updates the spell in the list of cards")
        void theMethodUpdateSpellUpdatesTheSpellInTheList() {
            // Arrange
            Spell spell = new Spell();
            // Act
            cardService.updateSpell(spell);
            // Assert
            verify(cardDaoMock, times(1)).updateSpell(any());
        }

    }
    @Nested
    class DeletingTests {
        @Test
        @DisplayName("DeleteCard: deletes the card of the same id")
        void theMethodDeleteCardDeletesTheCardInTheList() {
            // Arrange
            Integer id = 1;
            // Act
            cardService.deleteCard(id);
            // Assert
            verify(cardDaoMock, times(1)).deleteCard(any());
        }
    }
}
