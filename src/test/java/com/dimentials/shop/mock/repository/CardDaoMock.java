package com.dimentials.shop.mock.repository;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardDaoMock implements CardDao {

    List<CardEntity> cardEntityList = new ArrayList<>(
            List.of(
                    new MonsterEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                    new SpellEntity(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
            )
    );
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
        } else {
            throw new IllegalArgumentException("The card does not exist");
        }
        return card1;
    }

    @Override
    public SpellEntity updateSpell(SpellEntity spellEntity) {

        for (CardEntity card : cardEntityList) {
            if (Objects.equals(card.getId(), spellEntity.getId())) {
                card.setName(spellEntity.getName());
                card.setDescription(spellEntity.getDescription());
                card.setPrice(spellEntity.getPrice());
                card.setImgPath(spellEntity.getImgPath());
                if (card instanceof SpellEntity) {
                    ((SpellEntity) card).setMana(spellEntity.getMana());
                }
                return spellEntity;
            }
        }
        throw new IllegalArgumentException("The spell does not exist");
    }

    @Override
    public MonsterEntity updateMonster(MonsterEntity monsterEntity) {
        for (CardEntity card : cardEntityList) {
            if (Objects.equals(card.getId(), monsterEntity.getId())) {
                card.setName(monsterEntity.getName());
                card.setDescription(monsterEntity.getDescription());
                card.setPrice(monsterEntity.getPrice());
                card.setImgPath(monsterEntity.getImgPath());
                if (card instanceof MonsterEntity) {
                    ((MonsterEntity) card).setAttack(monsterEntity.getAttack());
                    ((MonsterEntity) card).setLife(monsterEntity.getLife());
                    ((MonsterEntity) card).setMainType(monsterEntity.getMainType());
                    ((MonsterEntity) card).setSecondaryType(monsterEntity.getSecondaryType());
                }
                return monsterEntity;
            }
        }
        throw new IllegalArgumentException("The spell does not exist");
    }
}
