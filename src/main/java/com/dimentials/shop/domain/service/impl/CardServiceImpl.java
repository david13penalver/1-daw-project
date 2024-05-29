package com.dimentials.shop.domain.service.impl;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
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
    public Card findById(Integer id) {
        return cardRepository.findById(id);
    }

    @Override
    public void addMonster(Monster monster) {
        cardRepository.addMonster(monster);
    }

    @Override
    public void addSpell(Spell spell) {
         cardRepository.addSpell(spell);
    }

    @Override
    public void deleteCard(Integer id) {
         cardRepository.deleteCard(id);
    }

    @Override
    public void updateSpell(Spell spell) {
         cardRepository.updateSpell(spell);
    }

    @Override
    public void updateMonster(Monster monster) {
         cardRepository.updateMonster(monster);
    }
}
