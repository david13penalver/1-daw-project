package com.dimentials.shop.persistence.dao.impl;

import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CardDao {

    List<CardEntity> cardEntityList = new ArrayList<>(
            List.of(
                    new CardEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(1), "Nebulsmokar.jpg"),
                    new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(1), "Lizzar.jpg"),
                    new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(1), "Frogan.jpg")
            )
    );

    @Override
    public List<CardEntity> findAll() {
        return cardEntityList;
    }

    @Override
    public CardEntity findById(int id) {
        for (CardEntity cardEntity : cardEntityList) {
            if (cardEntity.getId() == id) {
                return cardEntity;
            }
        }
        return null;
    }

    @Override
    cardEntity<List> addMonster(CardEntity cardEntity) {
        cardEntityList.add(cardEntity);
        return cardEntity;
    }

}
