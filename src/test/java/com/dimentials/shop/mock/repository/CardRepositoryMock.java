package com.dimentials.shop.mock.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
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
    public Monster addMonster(Monster monster) {
        cardList.add(monster);
        return monster;
    }

    @Override
    public Spell addSpell(Spell spell) {
        cardList.add(spell);
        return spell;
    }

    @Override
    public Card deleteCard(Integer id) {
        Card card1 = null;
        for (Card card : cardList) {
            if (card.getId() == id) {
                card1 = card;
            }
        }
        if (card1 != null) {
            cardList.remove(card1);
            return card1;
        }
        throw new IllegalArgumentException("The card does not exist");
    }

    @Override
    public Spell updateSpell(Spell spell) {
        for (Card card : cardList) {
            if (Objects.equals(card.getId(), spell.getId())) {
                card.setName(spell.getName());
                card.setDescription(spell.getDescription());
                card.setPrice(spell.getPrice());
                card.setImgPath(spell.getImgPath());
                if (card instanceof Spell) {
                    ((Spell) card).setMana(spell.getMana());
                }
                return spell;
            }
        }
            throw new IllegalArgumentException("The spell does not exist");
    }

        @Override
        public Monster updateMonster(Monster monster) {
            for (Card card : cardList) {
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
                    return monster;
                }
            }
            throw new IllegalArgumentException("The spell does not exist");
        }
    }
