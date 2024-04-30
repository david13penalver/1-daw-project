package com.dimentials.shop.domain.service;

import com.dimentials.shop.domain.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> findAll();

    Card findById(int id);

    Card addMonster(Card card);

    Card addSpell(Card card);
}
