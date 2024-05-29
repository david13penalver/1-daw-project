package com.dimentials.shop.persistence.dao;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;

import java.util.List;

public interface CardDao {
    List<CardEntity> findAll();

    CardEntity findById(Integer id);

    void addMonster(MonsterEntity monsterEntity);

    void addSpell(SpellEntity spellEntity);

    void deleteCard(Integer id);

    void updateSpell(SpellEntity spellEntity);

    void updateMonster(MonsterEntity monsterEntity);
}
