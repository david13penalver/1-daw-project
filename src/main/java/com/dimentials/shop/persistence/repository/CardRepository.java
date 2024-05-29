package com.dimentials.shop.persistence.repository;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;

import java.util.List;

public interface CardRepository {
    List<Card> findAll();

    Card findById(Integer id);

    void addMonster(Monster monster);

    void addSpell(Spell spell);

    void deleteCard(Integer id);

    void updateSpell(Spell spell);

    void updateMonster(Monster monster);
}
