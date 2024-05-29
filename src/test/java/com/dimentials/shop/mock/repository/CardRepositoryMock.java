package com.dimentials.shop.mock.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;
import com.dimentials.shop.persistence.repository.CardRepository;

public class CardRepositoryMock implements CardRepository {

    List<Card> cardList = new ArrayList<>(
            List.of(
                    new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new Card(2, "Lizzar", "Monstruito", "Lizzar.jpg"),
                    new Card(3, "Frogan", "Monstruitillo", "Frogan.jpg"),
                    new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
            )
    );
    public static List<Card> cardListMonsterAdded = new ArrayList<>(
            List.of(
                    new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new Card(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new Card(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                    new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
            )
    );

    public static List<Card> getCardListMonsterAdded() {
        return cardListMonsterAdded;
    }
    public static List<Card> cardListSpellAdded = new ArrayList<>(
            List.of(
                    new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new Card(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new Card(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                    new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
            )
    );

    public static List<Card> getCardListSpellAdded() {
        return cardListSpellAdded;
    }
    public static List<Card> cardListMonsterAltered = new ArrayList<>(
            List.of(
                    new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new Card(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new Card(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                    new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
            )
    );
    public static List<Card> getCardListMonsterAltered() {
        return cardListMonsterAltered;
    }
    public static List<Card> cardListSpellAltered = new ArrayList<>(
            List.of(
                    new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new Card(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new Card(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                    new Spell(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
            )
    );
    public static List<Card> getCardListSpellAltered() {
        return cardListSpellAltered;
    }
    public static List<Card> cardListCardDeleted = new ArrayList<>(
            List.of(
                    new Monster(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new Card(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new Card(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg")
            )
    );
    public static List<Card> getCardListCardDeleted() {
        return cardListCardDeleted;
    }

    @Override
    public List<Card> findAll() {
        return cardList;
    }

    @Override
    public Card findById(Integer id) {
        if (id == 1) {
            return cardList.get(0);
        }
        if (id == 2) {
            return cardList.get(1);
        }
        if (id == 3) {
            return cardList.get(2);
        }
        return null;
    }

    @Override
    public void addMonster(Monster monster) {
        cardListMonsterAdded.add(monster);
    }

    @Override
    public void addSpell(Spell spell) {
        cardListSpellAdded.add(spell);
    }

    @Override
    public void deleteCard(Integer id) {
        Card cardToDelete = null;
        for (Card card : cardList) {
            if (card.getId().equals(id)) {
                cardToDelete = card;
                break;
            }
        }
        if (cardToDelete != null) {
            cardListCardDeleted.remove(cardToDelete);
        } else {
            throw new IllegalArgumentException("The card does not exist");
        }
    }


    @Override
    public void updateSpell(Spell spell) {
        boolean updated = false;
        for (Card card : cardListSpellAltered) {
            if (Objects.equals(card.getId(), spell.getId())) {
                card.setName(spell.getName());
                card.setDescription(spell.getDescription());
                card.setPrice(spell.getPrice());
                card.setImgPath(spell.getImgPath());
                if (card instanceof Spell) {
                    ((Spell) card).setMana(spell.getMana());
                }
                updated = true;
                break;
            }
        }
        if (!updated) {
            throw new IllegalArgumentException("The spell does not exist");
        }
    }


    @Override
    public void updateMonster(Monster monster) {
        boolean updated = false;
        for (Card card : cardListMonsterAltered) {
            if (Objects.equals(card.getId(), monster.getId())) {
                card.setName(monster.getName());
                card.setDescription(monster.getDescription());
                card.setPrice(monster.getPrice());
                card.setImgPath(monster.getImgPath());
                if (card instanceof Monster) {
                    ((Monster) card).setAttack(monster.getAttack());
                    ((Monster) card).setLife(monster.getLife());
                    ((Monster) card).setMainType(monster.getMainType());
                    ((Monster) card).setSecondaryType(monster.getSecondaryType());
                }
                updated = true;
                break;
            }
        }
        if (!updated) {
            throw new IllegalArgumentException("The monster does not exist");
        }
    }

}
