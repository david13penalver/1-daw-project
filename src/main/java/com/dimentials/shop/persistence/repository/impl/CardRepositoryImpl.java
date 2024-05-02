package com.dimentials.shop.persistence.repository.impl;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.Monster;
import com.dimentials.shop.domain.entity.Spell;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;
import com.dimentials.shop.persistence.repository.CardRepository;
import com.dimentials.shop.persistence.repository.mapper.CardMapper;

import java.util.List;

public class CardRepositoryImpl implements CardRepository {

    private CardDao cardDao;

    public CardRepositoryImpl(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    public List<Card> findAll() {
        return CardMapper.toCardList(cardDao.findAll());
    }

    @Override
    public Card findById(Integer id) {
        return CardMapper.toCard(cardDao.findById(id));
    }

    @Override
    public Monster addMonster(Monster monster) {

        return CardMapper.toMonster(cardDao.addMonster(CardMapper.toMonsterEntity(monster)));
    }

    @Override
    public Spell addSpell(Spell spell) {
        return CardMapper.toSpell(cardDao.addSpell(CardMapper.toSpellEntity(spell)));

    }

    @Override
    public Card deleteCard(Integer id) {
        return CardMapper.toCard(cardDao.deleteCard(id));
    }

    @Override
    public Spell updateSpell(Spell spell) {
        return CardMapper.toSpell(cardDao.updateSpell(CardMapper.toSpellEntity(spell)));
    }

    @Override
    public Monster updateMonster(Monster monster) {
        return CardMapper.toMonster(cardDao.updateMonster(CardMapper.toMonsterEntity(monster)));
    }

}
