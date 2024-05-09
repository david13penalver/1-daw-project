package com.dimentials.shop.unit.domain.service;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.domain.service.CardService;
import com.dimentials.shop.domain.service.impl.CardServiceImpl;
import com.dimentials.shop.mock.repository.CardRepositoryMock;
import com.dimentials.shop.persistence.repository.CardRepository;
import com.dimentials.shop.persistence.repository.impl.CardRepositoryImpl;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardServiceImplTest {

    private final CardRepository cardRepository = new CardRepositoryMock();
    private final CardService cardService = new CardServiceImpl(cardRepository);

    private List<Card> expectedList;
    @BeforeEach
    void setUp() {
        expectedList = new ArrayList<>(
                List.of(
                        new Card(1, "Nebulsmokar", "Monstruo", "Nebulsmokar.jpg"),
                        new Card(2, "Lizzar", "Monstruito", "Lizzar.jpg"),
                        new Card(3, "Frogan", "Monstruitillo", "Frogan.jpg"),
                        new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
                )
        );
    }

    @Nested
    class findAllTest {
        @Test
        @DisplayName("The methods findAll() returns all the cards")
        void findAllReturnsAllCards() {
            List<Card> cardList = cardRepository.findAll();

            assertEquals(expectedList, cardList);
        }
    }

    @Nested
    class FindByIdTest {
        @Test
        @DisplayName("The methods findById(1) returns the card inserted at the parameter")
        void findById1ReturnsTheBookWithTheFirstId() {

            Card cardExpected1 = expectedList.get(0);

            Card card1 = cardRepository.findById(1);

            assertEquals(cardExpected1, card1);
        }

        @Test
        @DisplayName("The methods findById(2) returns the card inserted at the parameter")
        void findById2ReturnsTheBookWithTheSecondId() {
            Card cardExpected2 = expectedList.get(1);

            Card card2 = cardRepository.findById(2);

            assertEquals(cardExpected2, card2);
        }

        @Test
        @DisplayName("The methods findById(id) not found returns null")
        void findByIdNotFoundReturnsNull() {
            Card card3 = cardRepository.findById(5);

            assertNull(card3);
        }
    }

    @Nested
    @DisplayName("The methods add*() returns the monster/spell inserted")
    class AddingTests {
        @Test
        @DisplayName("The methods addMonster() returns the monster inserted")
        void addMonsterReturnsTheMonsterInserted() {
            Monster card = new Monster(5, "Nebulsmokar2", "Monstruo bla bla", new BigDecimal(10), "Nebulsmokar.jpg", 10, 10, "Fuego", "Agua");

            Monster cardAdded = cardRepository.addMonster(card);

            assertEquals(card, cardAdded);
        }

        @Test
        @DisplayName("The methods addSpell() returns the spell inserted")
        
        void addSpellReturnsTheSpellInserted() {
            Spell spell = new Spell(4,"borj", "locura", new BigDecimal(10), "Borja.jpg", 10);

            Spell spellAdded = cardRepository.addSpell(spell);

            assertEquals(spell, spellAdded);
        }
    }

    @Nested
    class udpateTests {
        @Test
        @DisplayName("The methods addSpell() returns the spell inserted")
        void updateSpellReturnsTheSpellUpdated() {
            Spell spell = new Spell(4,"dario", "mala locura", new BigDecimal(13), "Dario.jpg", 9);

            Spell spellUpdated = cardRepository.updateSpell(spell);

            assertEquals(spell, spellUpdated);
        }
    }


}
