package com.dimentials.shop.persistence.dao;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.dao.entity.CardEntity;

import java.util.List;

public interface CardDao {
    List<CardEntity> findAll();

    CardEntity findById(int id);

    MonsterEntity addMonster(MonsterEntity monsterEntity);

    SpellEntity addSpell(SpellEntity spellEntity);
}
