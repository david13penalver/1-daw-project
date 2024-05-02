package com.dimentials.shop.mock.repository;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.persistence.repository.CardRepository;

import java.util.List;

public class CardRepositoryMock implements CardRepository {

    List<Card> cardList = List.of(
            new Card(1, "Nebulsmokar", "Monstruo", "Nebulsmokar.jpg"),
            new Card(2, "Lizzar", "Monstruito", "Lizzar.jpg"),
            new Card(3, "Frogan", "Monstruitillo", "Frogan.jpg"));

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
        return null;
    }

    @Override
    public Spell addSpell(Spell spell) {
        return null;
    }

    @Override
    public Card deleteCard(Integer id) {
        return null;
    }

    @Override
    public Spell updateSpell(Spell spell) {
        return null;
    }

    @Override
    public Monster updateMonster(Monster monster) {
        return null;
    }
}
