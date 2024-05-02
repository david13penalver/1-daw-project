package com.dimentials.shop.mock.repository;

import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CardDaoMock implements CardDao {

    List<CardEntity> cardEntityList = new ArrayList<>(
            List.of(
                    new CardEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(1), "Nebulsmokar.jpg"),
                    new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(1), "Lizzar.jpg"),
                    new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(1), "Frogan.jpg")));

    @Override
    public List<CardEntity> findAll() {
        return cardEntityList;
    }

    @Override
    public CardEntity findById(Integer id) {
        return null;
    }

    public CardEntity findById(Integer id) {
        if (id == 1) {
            return cardEntityList.get(0);
        }
        if (id == 2) {
            return cardEntityList.get(1);
        }
        if (id == 3) {
            return cardEntityList.get(2);
        }
        return null;
    }

    @Override
    public MonsterEntity addMonster(MonsterEntity monsterEntity) {

        return null;
    }

    @Override
    public SpellEntity addSpell(SpellEntity spellEntity) {
        return null;
    }

    @Override
    public CardEntity deleteCard(Integer id) {
        return null;
    }

    @Override
    public SpellEntity updateSpell(SpellEntity spellEntity) {
        return null;
    }

    @Override
    public MonsterEntity updateMonster(MonsterEntity monsterEntity) {
        return null;
    }
}
