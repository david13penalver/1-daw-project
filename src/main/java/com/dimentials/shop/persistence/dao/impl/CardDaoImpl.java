package com.dimentials.shop.persistence.dao.impl;

import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CardDao {

    List<CardEntity> cardEntityList = new ArrayList<>(
            List.of(
                    new CardEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(1), "Nebulsmokar.jpg"),
                    new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(1), "Lizzar.jpg"),
                    new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(1), "Frogan.jpg"),
                    new SpellEntity(4, "Fireball", "Hechizo", new BigDecimal(1), "Fireball.jpg", 5)
            )
    );

    @Override
    public List<CardEntity> findAll() {
        return cardEntityList;
    }

    @Override
    public CardEntity findById(Integer id) {
        for (CardEntity cardEntity : cardEntityList) {
            if (cardEntity.getId() == id) {
                return cardEntity;
            }
        }
        return null;
    }

    @Override
    public void addMonster(MonsterEntity monsterEntity) {
        cardEntityList.add(monsterEntity);

    }

    @Override
    public void addSpell(SpellEntity spellEntity) {
        cardEntityList.add(spellEntity);
    }

    @Override
    public void deleteCard(Integer id) {
        CardEntity cardToRemove = null;
        for (CardEntity cardEntity : cardEntityList) {
            if (cardEntity.getId() == id) {
                cardToRemove = cardEntity;
                break;
            }
        }
        if (cardToRemove != null) {
            cardEntityList.remove(cardToRemove);
        }
    }

    @Override
    public void updateSpell(SpellEntity spellEntity) {
        for (CardEntity card : cardEntityList) {
            if (card.getId() == spellEntity.getId()) {
                card.setName(spellEntity.getName());
                card.setDescription(spellEntity.getDescription());
                card.setPrice(spellEntity.getPrice());
                card.setImgPath(spellEntity.getImgPath());
            }
        }
    }

    @Override
    public void updateMonster(MonsterEntity monsterEntity) {
        for (CardEntity card : cardEntityList) {
            if (card.getId() == monsterEntity.getId()) {
                card.setName(monsterEntity.getName());
                card.setDescription(monsterEntity.getDescription());
                card.setPrice(monsterEntity.getPrice());
                card.setImgPath(monsterEntity.getImgPath());
            }
        }
    }

}
