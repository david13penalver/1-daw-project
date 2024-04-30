package com.dimentials.shop.persistence.repository.mapper;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.dao.entity.CardEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CardMapper {
    public static Card toCard(CardEntity cardEntity) {
        if (cardEntity == null)
            return null;
        Integer id = cardEntity.getId();
        String name = cardEntity.getName();
        String description = cardEntity.getDescription();
        String imgPath = cardEntity.getImgPath();
        BigDecimal price = cardEntity.getPrice();

        return new Card(id, name, description, price, imgPath);
    }

    public static List<Card> toCardList(List<CardEntity> cardEntityList) {
        if (cardEntityList == null)
            return null;
        List<Card> cardList = new ArrayList<>();

        for (CardEntity cardEntity : cardEntityList) {
            cardList.add(toCard(cardEntity));
        }
        return cardList;
    }

    public static monster toMonster(MonsterEntity monsterEntity) {
        if (monsterEntity == null)
            return null;
        else {
            Integer id = monsterEntity.getId();
            String name = monsterEntity.getName();
            String description = monsterEntity.getDescription();
            String imgPath = monsterEntity.getImgPath();
            BigDecimal price = monsterEntity.getPrice();
            Integer attack = monsterEntity.getAttack();
            Integer life = monsterEntity.getLife();
            String mainType = monsterEntity.getMainType();
            String secondaryType = monsterEntity.getSecondaryType();
            return new Monster(id, name, description, price, imgPath, attack, life, mainType, secondaryType);

        }
    }
}
