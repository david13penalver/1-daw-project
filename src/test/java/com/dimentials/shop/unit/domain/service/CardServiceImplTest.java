package com.dimentials.shop.unit.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dimentials.shop.mock.repository.CardDaoMock;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.repository.mapper.CardMapper;
import org.junit.jupiter.api.*;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.domain.service.CardService;
import com.dimentials.shop.domain.service.impl.CardServiceImpl;
import com.dimentials.shop.persistence.repository.CardRepository;

import com.dimentials.shop.mock.repository.CardRepositoryMock;
public class CardServiceImplTest {

    private final CardRepository cardRepository = new CardRepositoryMock();
    private final CardService cardService = new CardServiceImpl(cardRepository);

    private List<Card> expectedList;

    @BeforeEach
    void setUp() {
        expectedList = new ArrayList<>(
                List.of(
                        new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                                "Fuego", "Agua"),
                        new Card(2, "Lizzar", "Monstruito", "Lizzar.jpg"),
                        new Card(3, "Frogan", "Monstruitillo", "Frogan.jpg"),
                        new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)));
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
            Monster card = new Monster(5, "Nebulsmokar2", "Monstruo bla bla", new BigDecimal(10), "Nebulsmokar.jpg", 10,
                    10, "Fuego", "Agua");

            cardRepository.addMonster(card);
            List<Card> expectedList1 = new ArrayList<>(
                    List.of(
                            new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                                    "Fuego", "Agua"),
                            new Card(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                            new Card(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                            new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10),
                            new Monster(5, "Nebulsmokar2", "Monstruo bla bla", new BigDecimal(10), "Nebulsmokar.jpg", 10,
                                    10, "Fuego", "Agua")
                    )
            );

            List<Card> resultList = CardRepositoryMock.getCardListMonsterAdded();

            assertEquals(expectedList1, resultList);
        }

        @Test
        @DisplayName("The methods addSpell() returns the spell inserted")

        void addSpellReturnsTheSpellInserted() {
            Spell spell = new Spell(5, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10);

            cardRepository.addSpell(spell);

            List<Card> expectedList1 = new ArrayList<>(
                    List.of(
                            new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                                    "Fuego", "Agua"),
                            new Card(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                            new Card(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                            new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10),
                            new Spell(5, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
                    )
            );

            List<Card> resultList = CardRepositoryMock.getCardListSpellAdded();

            assertEquals(expectedList1, resultList);
        }
    }

    @Nested
    class udpateTests {
        @Test
        @DisplayName("The methods updateSpell() returns the spell updated")
        void updateSpellReturnsTheSpellUpdated() {

            List<Card> expectedList2 = new ArrayList<>(
                    List.of(
                            new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                                    "Fuego", "Agua"),
                            new Card(2, "Lizzar", "Monstruito", "Lizzar.jpg"),
                            new Card(3, "Frogan", "Monstruitillo", "Frogan.jpg"),
                            new Spell(4, "dario", "muchalocura", new BigDecimal(20), "dario.jpg", 20)
                    )
            );
            Spell spell = new Spell(4, "dario", "muchalocura", new BigDecimal(20), "dario.jpg", 20);

            cardRepository.updateSpell(spell);

            List<Card> resultList = CardRepositoryMock.getCardListSpellAltered();

            assertEquals(expectedList2, resultList);
        }

        @Test
        @DisplayName("The methods updateMonster() returns the monster updated")
        void updateMonsterReturnsTheMonsterUpdated() {
            List<Card> expectedList2 = new ArrayList<>(
                    List.of(
                            new Monster(1, "cuerk", "Monstruo despiadado", new BigDecimal(7), "binchilling.jpg", 6, 7,
                                    "Fuego", "Agua"),
                            new Card(2, "Lizzar", "Monstruito", "Lizzar.jpg"),
                            new Card(3, "Frogan", "Monstruitillo", "Frogan.jpg"),
                            new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
                    )
            );

            Monster monster = new Monster(1, "cuerk", "Monstruo despiadado", new BigDecimal(7), "binchilling.jpg", 6, 7,
                    "Fuego", "Agua");

            cardRepository.updateMonster(monster);

            assertEquals(expectedList2, cardRepository.findAll());
        }

        @Test
        @DisplayName("The methods updateMonster() but with ID not found")
        void updateMonsterReturnsTheMonsterUpdatedWithIdNotFound() {
            Monster monster = new Monster(110, "cuerk", "Monstruo despiadado", new BigDecimal(7), "binchilling.jpg", 6,
                    7, "Fuego", "Agua");

            assertThrows(IllegalArgumentException.class, () -> cardRepository.updateMonster(monster));
        }

        @Test
        @DisplayName("The methods updateSpell() but with ID not found")
        void updateSpellReturnsTheSpellUpdatedWithIdNotFound() {
            Spell spell = new Spell(111, "dario", "mala locura", new BigDecimal(13), "Dario.jpg", 9);

            assertThrows(IllegalArgumentException.class, () -> cardRepository.updateSpell(spell));
        }

    }

    @Nested
    class deleteTests {
        @Test
        @DisplayName("The methods deleteCard() returns the monster deleted")
        
        void deleteCardReturnsTheMonsterDeleted() {
            List<Card> cardList = new ArrayList<>(
                List.of(
                        new Card(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                        new Card(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg")
                )
            );

            cardRepository.deleteCard(1);

            List<Card> resultList = CardRepositoryMock.getCardListCardDeleted();

            assertEquals(cardList, resultList);
        }

        @Test
        @DisplayName("The methods deleteCard() throws an exception when the card does not exist")
        void deleteCardThatDoesntExist() {
            assertThrows(IllegalArgumentException.class, () -> cardRepository.deleteCard(5));
        }
        
    }

}
