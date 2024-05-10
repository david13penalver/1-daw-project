package com.dimentials.shop.unit.persistence.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;
import org.junit.jupiter.api.*;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.mock.repository.CardDaoMock;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.repository.CardRepository;
import com.dimentials.shop.persistence.repository.impl.CardRepositoryImpl;
import com.dimentials.shop.persistence.repository.mapper.CardMapper;

import static org.junit.jupiter.api.Assertions.*;

public class CardRepositoryImplTest {
    private final CardDao cardDao = new CardDaoMock();
    private final CardRepository cardRepository = new CardRepositoryImpl(cardDao);


    private List<Card> expectedList;

    @BeforeEach
    void setUp() {
        expectedList = new ArrayList<>(
                List.of(
                        new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                                "Fuego", "Agua"),
                        new Card(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                        new Card(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                        new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
                )
        );
    }

    @Nested
    class FindTests {

        @Test
        @DisplayName("The methods findAll() returns all the cards")
        void findAllReturnsAllCards() {
            List<Card> cardList = CardMapper.toCardList(cardDao.findAll());

            assertEquals(expectedList, cardList);
        }

        @Nested
        class findById {

            @Test
            @DisplayName("The methods findById(1), that is concretelly a monster, returns the card inserted at the parameter")
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
            @DisplayName("The methods findById(1) returns the card inserted at the parameter")
            void findById1ReturnsTheBookWithTheThirdId() {
                Card cardExpected1 = expectedList.get(2);

                Card card1 = CardMapper.toCard(cardDao.findById(3));

                assertEquals(cardExpected1, card1);
            }

            @Test
            @DisplayName("The methods findById(1), that is concretelly a spell, returns the card inserted at the parameter")
            void findById1ReturnsTheBookWithTheFourthId() {
                Card cardExpected1 = expectedList.get(3);

                Card card1 = CardMapper.toCard(cardDao.findById(4));

                assertEquals(cardExpected1, card1);
            }

            @Test
            @DisplayName("The methods findById(id) not found returns null")
            void findByIdNotFoundReturnsNull() {
                Card card3 = CardMapper.toCard(cardDao.findById(10));

                assertNull(card3);
            }
        }
    }

    @Nested
    @DisplayName("AddingTests")
    class AddingTests {
            @Test
            @DisplayName("The methods addMonster() returns the monster inserted")
            void addMonsterReturnsTheMonsterInserted() {
                Monster monster = new Monster(4, "cuerk", "Monstruo despiadado", new BigDecimal(7), "binchilling.jpg", 6, 7,
                        "Fuego", "Agua");

                Monster monsterInserted = CardMapper.toMonster(cardDao.addMonster(CardMapper.toMonsterEntity(monster)));

                assertEquals(monster, monsterInserted);
            }

            @Test
            @DisplayName("The methods addSpell() returns the spell inserted")
            void addSpellReturnsTheSpellInserted() {
                Spell spell = new Spell(4, "dario", "mala locura", new BigDecimal(13), "Dario.jpg", 9);

                Spell spellInserted = CardMapper.toSpell(cardDao.addSpell(CardMapper.toSpellEntity(spell)));

                assertEquals(spell, spellInserted);
            }
        }


    @Nested
    @DisplayName("UpdateTests")
    class UpdateTests {
        @Test
        @DisplayName("The methods updateSpell() returns the spell updated")
        void updateSpellReturnsTheSpellUpdated() {
            Spell spell = new Spell(4, "dario", "mala locura", new BigDecimal(13), "Dario.jpg", 9);

            Spell spellUpdated =CardMapper.toSpell(cardDao.updateSpell(CardMapper.toSpellEntity(spell)));

            assertEquals(spell, spellUpdated);
        }

        @Test
        @DisplayName("The methods updateMonster() returns the monster updated")
        void updateMonsterReturnsTheMonsterUpdated() {
            Monster monster = new Monster(1, "cuerk", "Monstruo despiadado", new BigDecimal(7), "binchilling.jpg", 6, 7,
                        "Fuego", "Agua");

            Monster monsterUpdated = CardMapper.toMonster(cardDao.updateMonster(CardMapper.toMonsterEntity(monster)));

            assertEquals(monster, monsterUpdated);
        }

        @Test
        @DisplayName("The methods updateMonster() but with ID not found")
        void updateMonsterButWithIdNotFound() {
            Monster monster = new Monster(10, "cuerk", "Monstruo despiadado", new BigDecimal(7), "binchilling.jpg", 6, 7,
                        "Fuego", "Agua");

            //Monster monsterUpdated = CardMapper.toMonster(cardDao.updateMonster(CardMapper.toMonsterEntity(monster)));

            assertThrows(IllegalArgumentException.class, () -> cardDao.updateMonster(CardMapper.toMonsterEntity(monster)));
        }

        @Test
        @DisplayName("The methods updateSpell() but with ID not found")
        void updateSpellButWithIdNotFound() {
            Spell spell = new Spell(10, "dario", "mala locura", new BigDecimal(13), "Dario.jpg", 9);

            //Spell spellUpdated = CardMapper.toSpell(cardDao.updateSpell(CardMapper.toSpellEntity(spell)));

            assertThrows(IllegalArgumentException.class, () -> cardDao.updateSpell(CardMapper.toSpellEntity(spell)));
        }
    }

    @Nested
    @DisplayName("DeleteTests")
    class DeleteTests {
            @Test
            @DisplayName("The methods deleteCard() returns the card deleted")
            void deleteCardReturnsTheCardDeleted() {

                List<CardEntity> cardEntityListExpected = new ArrayList<>(
                        List.of(
                                new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                                new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                                new SpellEntity(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
                        )
                );

                CardMapper.toCard(cardDao.deleteCard(1));

                List<CardEntity> cardGot = cardDao.findAll();

                assertEquals(cardEntityListExpected, cardGot);
            }

            @Test
            @DisplayName("The methods deleteCard() but with ID not found")
            void deleteCardButWithIdNotFound() {
                //Card card = new Card(10, "Nebulsmokar", "Monstruo", new BigDecimal(1), "Nebulsmokar.jpg");

                //Card cardDeleted = CardMapper.toCard(cardDao.deleteCard(10));

                assertThrows(IllegalArgumentException.class, () -> cardDao.deleteCard(10));
            }
        }
}
