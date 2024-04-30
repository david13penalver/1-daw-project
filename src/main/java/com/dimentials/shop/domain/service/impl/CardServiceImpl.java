package com.dimentials.shop.domain.service.impl;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.service.CardService;
import com.dimentials.shop.persistence.repository.CardRepository;

import java.util.List;

public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findById(int id) {
        return cardRepository.findById(id);
    }

    @Override
    public Card addMonster(Card card) {
        return cardRepository.addMonster(card);
    }
}
