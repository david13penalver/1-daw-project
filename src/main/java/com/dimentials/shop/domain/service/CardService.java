package com.dimentials.shop.domain.service;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;

import java.util.List;

public interface CardService {
    List<Card> findAll();

    Card findById(Integer id);

    void addMonster(Monster monster);

    void addSpell(Spell spell);

    void deleteCard(Integer id);

    void updateSpell(Spell spell);

    void updateMonster(Monster monster);
}
