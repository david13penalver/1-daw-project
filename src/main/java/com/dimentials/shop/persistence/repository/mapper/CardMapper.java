package com.dimentials.shop.persistence.repository.mapper;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CardMapper {
    public static Card toCard(CardEntity cardEntity) {
        if (cardEntity == null)
            return null;
        if (cardEntity instanceof MonsterEntity)
            return toMonster((MonsterEntity) cardEntity);
        if (cardEntity instanceof SpellEntity)
            return toSpell((SpellEntity) cardEntity);
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
            if (cardEntity instanceof MonsterEntity)
                cardList.add(toMonster((MonsterEntity) cardEntity));
            else if (cardEntity instanceof SpellEntity)
                cardList.add(toSpell((SpellEntity) cardEntity));
            else
                cardList.add(toCard(cardEntity));
        }
        return cardList;
    }

    public static Monster toMonster(MonsterEntity monsterEntity) {
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


    public static Spell toSpell(SpellEntity spellEntity) {
        if (spellEntity == null)
            return null;
        else {
            Integer id = spellEntity.getId();
            String name = spellEntity.getName();
            String description = spellEntity.getDescription();
            String imgPath = spellEntity.getImgPath();
            BigDecimal price = spellEntity.getPrice();
            Integer mana = spellEntity.getMana();
            return new Spell(id, name, description, price, imgPath, mana);
        }
    }

    public static MonsterEntity toMonsterEntity(Monster monster) {
        if (monster == null)
            return null;
        else {
            Integer id = monster.getId();
            String name = monster.getName();
            String description = monster.getDescription();
            String imgPath = monster.getImgPath();
            BigDecimal price = monster.getPrice();
            Integer attack = monster.getAttack();
            Integer life = monster.getLife();
            String mainType = monster.getMainType();
            String secondaryType = monster.getSecondaryType();
            return new MonsterEntity(id, name, description, price, imgPath, attack, life, mainType, secondaryType);
        }
    }

    public static MonsterEntity toMonsterEntityLanguages(Monster monster) {
        if (monster == null)
            return null;
        else {
            Integer id = monster.getId();
            String name = monster.getName();
            String description_es = monster.getDescription_es();
            String description_en = monster.getDescription_en();
            String imgPath = monster.getImgPath();
            BigDecimal price = monster.getPrice();
            Integer attack = monster.getAttack();
            Integer life = monster.getLife();
            String mainType_es = monster.getMainType_es();
            String mainType_en = monster.getMainType_en();
            String secondaryType_es = monster.getSecondaryType_es();
            String secondaryType_en = monster.getSecondaryType_en();
            return new MonsterEntity(id, name, description_es, description_en, price, imgPath, attack, life, mainType_es, mainType_en, secondaryType_es, secondaryType_en);
        }
    }

    public static SpellEntity toSpellEntity(Spell spell) {
        if (spell == null)
            return null;
        else {
            Integer id = spell.getId();
            String name = spell.getName();
            String description = spell.getDescription();
            String imgPath = spell.getImgPath();
            BigDecimal price = spell.getPrice();
            Integer mana = spell.getMana();
            return new SpellEntity(id, name, description, price, imgPath, mana);
        }
    }
}
