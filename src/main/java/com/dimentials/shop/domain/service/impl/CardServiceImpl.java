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
    public Card findById(int id) {
        return cardRepository.findById(id);
    }

    @Override
    public Monster addMonster(Monster monster) {
        return cardRepository.addMonster(monster);
    }
    @Override
    public Spell addSpell(Spell spell) {
        return cardRepository.addSpell(spell);
    }
    @Override
    public Card deleteCard(Integer id) {
        return cardRepository.deleteCard(id);
    }

    @Override
    public Spell updateSpell(Spell spell) {
        return cardRepository.updateSpell(spell);
    }

    @Override
    public Monster updateMonster(Monster monster) {
        return cardRepository.updateMonster(monster);
    }
}
