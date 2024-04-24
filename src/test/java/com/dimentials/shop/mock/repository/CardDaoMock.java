package com.dimentials.shop.mock.repository;

import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;

import java.math.BigDecimal;
import java.util.List;

public class CardDaoMock implements CardDao {

    List<CardEntity> CardEntityList = List.of(
            new CardEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(1), "Nebulsmokar.jpg"),
            new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(1), "Lizzar.jpg"),
            new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(1), "Frogan.jpg")
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
