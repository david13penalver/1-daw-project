package com.dimentials.shop.persistence.dao.impl;

import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;

import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CardDao {

    List<CardEntity> cardEntityList = List.of(
            new CardEntity(1, "Nebulsmokar", "Monstruo"),
            new CardEntity(2, "Lizzar", "Monstruito"),
            new CardEntity(3, "Frogan", "Monstruitillo")
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
}