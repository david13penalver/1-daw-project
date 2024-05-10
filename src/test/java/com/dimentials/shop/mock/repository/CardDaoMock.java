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
    private Integer id;

    @Override
    public List<CardEntity> findAll() {
        return cardEntityList;
    }

    @Override
    public CardEntity findById(Integer id) {
        for (CardEntity cardEntity : cardEntityList) {
            if (cardEntity.getId().equals(id)) {
                return cardEntity;
            }
        }
        return null;
    }

    @Override
    public MonsterEntity addMonster(MonsterEntity monsterEntity) {

        cardEntityList.add(monsterEntity);
        return monsterEntity;
    }

    @Override
    public SpellEntity addSpell(SpellEntity spellEntity) {
        cardEntityList.add(spellEntity);
        return spellEntity;
    }

    @Override
    public CardEntity deleteCard(Integer id) {
        CardEntity card1 = null;
        for (CardEntity card : cardEntityList) {
            if (card.getId().equals(id)) {
                card1 = card;
            }
        }
        if (card1 != null) {
            cardEntityList.remove(card1);
        }
        return card1;
    }

    @Override
    public SpellEntity updateSpell(SpellEntity spellEntity) {

        for (CardEntity cardEntity : cardEntityList) {
            if (cardEntity.getId().equals(spellEntity.getId())) {

                cardEntity.setId(spellEntity.getId());
                cardEntity.setName(spellEntity.getName());
                cardEntity.setDescription(spellEntity.getDescription());
                cardEntity.setPrice(spellEntity.getPrice());
                cardEntity.setImgPath(spellEntity.getImgPath());
                spellEntity.setMana(spellEntity.getMana());

            } else {
                throw new IllegalArgumentException("The spell does not exist");
            }
            return spellEntity;
        }
    }

    @Override
    public MonsterEntity updateMonster(MonsterEntity monsterEntity) {
        for (CardEntity cardEntity : cardEntityList) {
            if (cardEntity.getId().equals(monsterEntity.getId())) {
                cardEntity.setId(monsterEntity.getId());
                cardEntity.setName(monsterEntity.getName());
                cardEntity.setDescription(monsterEntity.getDescription());
                cardEntity.setPrice(monsterEntity.getPrice());
                cardEntity.setImgPath(monsterEntity.getImgPath());
                monsterEntity.setAttack(monsterEntity.getAttack());
                monsterEntity.setLife(monsterEntity.getLife());
                monsterEntity.setMainType(monsterEntity.getMainType());
                monsterEntity.setSecondaryType(monsterEntity.getSecondaryType());
            } else {
                throw new IllegalArgumentException("The monster does not exist");
            }
            return monsterEntity;
        }
    }
}
