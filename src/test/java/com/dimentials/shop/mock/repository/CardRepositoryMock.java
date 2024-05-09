package com.dimentials.shop.mock.repository;

import java.util.ArrayList;
import java.util.List;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.repository.CardRepository;

public class CardRepositoryMock implements CardRepository {

    List<Card> cardList = new ArrayList<>(
            List.of(
                    new Card(1, "Nebulsmokar", "Monstruo", "Nebulsmokar.jpg"),
                    new Card(2, "Lizzar", "Monstruito", "Lizzar.jpg"),
                    new Card(3, "Frogan", "Monstruitillo", "Frogan.jpg"))
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
        return null;
    }

    @Override
    public Spell updateSpell(Spell spell) {
        for (Card card : cardList) {
            if (card.getId() == spell.getId()) {
                card.setName(spell.getName());
                card.setDescription(spell.getDescription());
                card.setPrice(spell.getPrice());
                card.setImgPath(spell.getImgPath());
                spell.setMana(spell.getMana());
            }
            else {
                throw new IllegalArgumentException("The spell does not exist");
            }
        }
        return spell;
    }

        @Override
        public Monster updateMonster(Monster monster) {
            for (Card card : cardList) {
                if (card.getId() == monster.getId()) {
                    card.setName(monster.getName());
                    card.setDescription(monster.getDescription());
                    card.setPrice(monster.getPrice());
                    card.setImgPath(monster.getImgPath());
                    monster.setAttack(monster.getAttack());
                    monster.setLife(monster.getLife());
                    monster.setMainType(monster.getMainType());
                    monster.setSecondaryType(monster.getSecondaryType());
                    
                }
                else {
                    throw new IllegalArgumentException("The spell does not exist");
                }
            }
            return monster;
        }
    }
