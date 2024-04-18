package com.dimentials.shop.mock.repository;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.repository.CardRepository;


import java.util.List;

public class CardDaoMock implements CardDao {

    List<CardEntity> CardEntityList = List.of(
            new CardEntity(1, "Nebulsmokar", "Monstruo"),
            new CardEntity(2, "Lizzar", "Monstruito"),
            new CardEntity(3, "Frogan", "Monstruitillo")
    );
    @Override
    public List<CardEntity> findAll() {
        return CardEntityList;
    }

    @Override
    public CardEntity findById(int id) {
        if (id == 1) {
            return CardEntityList.get(0);
        }
        if (id == 2) {
            return CardEntityList.get(1);
        }
        if (id == 3) {
            return CardEntityList.get(2);
        }
        return null;
    }
}
