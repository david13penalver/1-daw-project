package com.dimentials.shop.domain.service;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;

import java.util.List;

public interface CardService {
    List<Card> findAll();

    Card findById(Integer id);

    Monster addMonster(Monster monster);

    Spell addSpell(Spell spell);

    Card deleteCard(Integer id);

    Spell updateSpell(Spell spell);

    Monster updateMonster(Monster monster);
}
