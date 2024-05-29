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
    public static List<CardEntity> cardEntityListMonsterAdded = new ArrayList<>(
            List.of(
                    new MonsterEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                    new SpellEntity(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
            )
    );

    public static List<CardEntity> getCardEntityListMonsterAdded() {
        return cardEntityListMonsterAdded;
    }
    public static List<CardEntity> cardEntityListSpellAdded = new ArrayList<>(
            List.of(
                    new MonsterEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                    new SpellEntity(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
            )
    );

    public static List<CardEntity> getCardEntityListSpellAdded() {
        return cardEntityListSpellAdded;
    }
    public static List<CardEntity> cardEntityListMonsterAltered = new ArrayList<>(
            List.of(
                    new MonsterEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                    new SpellEntity(4, "dario", "mala locura", new BigDecimal(13), "Dario.jpg", 9)
            )
    );
    public static List<CardEntity> getCardEntityListMonsterAltered() {
        return cardEntityListMonsterAltered;
    }
    public static List<CardEntity> cardEntityListSpellAltered = new ArrayList<>(
            List.of(
                    new MonsterEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg"),
                    new SpellEntity(4, "borj", "locura", new BigDecimal(10), "Borja.jpg", 10)
            )
    );
    public static List<CardEntity> getCardEntityListSpellAltered() {
        return cardEntityListSpellAltered;
    }
    public static List<CardEntity> cardEntityListCardDeleted = new ArrayList<>(
            List.of(
                    new MonsterEntity(1, "Nebulsmokar", "Monstruo", new BigDecimal(7), "binchilling.jpg", 6, 7,
                            "Fuego", "Agua"),
                    new CardEntity(2, "Lizzar", "Monstruito", new BigDecimal(7), "Lizzar.jpg"),
                    new CardEntity(3, "Frogan", "Monstruitillo", new BigDecimal(7), "Frogan.jpg")
            )
    );
    public static List<CardEntity> getCardEntityListCardDeleted() {
        return cardEntityListCardDeleted;
    }

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
    public void addMonster(MonsterEntity monsterEntity) {

        cardEntityListMonsterAdded.add(monsterEntity);
    }

    @Override
    public void addSpell(SpellEntity spellEntity) {
        cardEntityListSpellAdded.add(spellEntity);
    }

    @Override
    public void deleteCard(Integer id) {
        CardEntity card1 = null;
        for (CardEntity card : cardEntityListCardDeleted) {
            if (card.getId().equals(id)) {
                card1 = card;
            }
        }
        if (card1 != null) {
            cardEntityListCardDeleted.remove(card1);
        } else {
            throw new IllegalArgumentException("The card does not exist");
        }
    }

    @Override
    public void updateSpell(SpellEntity spellEntity) {
        boolean updated = false;
        for (CardEntity card : cardEntityListSpellAltered) {
            if (Objects.equals(card.getId(), spellEntity.getId())) {
                card.setName(spellEntity.getName());
                card.setDescription(spellEntity.getDescription());
                card.setPrice(spellEntity.getPrice());
                card.setImgPath(spellEntity.getImgPath());
                if (card instanceof SpellEntity) {
                    ((SpellEntity) card).setMana(spellEntity.getMana());
                }
                updated = true;
                break;
            }
        }
        if (!updated) {
            throw new IllegalArgumentException("The spell does not exist");
        }
    }

    @Override
    public void updateMonster(MonsterEntity monsterEntity) {
        boolean updated = false;
        for (CardEntity card : cardEntityListMonsterAltered) {
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
                updated = true;
                break;
            }
        }
        if (!updated) {
            throw new IllegalArgumentException("The monster does not exist");
        }    }
}
