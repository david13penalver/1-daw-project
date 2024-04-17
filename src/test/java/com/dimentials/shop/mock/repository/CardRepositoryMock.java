package com.dimentials.shop.mock.repository;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.repository.CardRepository;

import java.util.List;

public class CardRepositoryMock implements CardRepository {

    List<Card> cardList = List.of(
            new Card(1, "Nebulsmokar", "Monstruo"),
            new Card(2, "Lizzar", "Monstruito"),
            new Card(3, "Frogan", "Monstruitillo")
    );
    @Override
    public List<Card> findAll() {
        return cardList;
    }

    @Override
    public Card findById(int id) {
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
}
