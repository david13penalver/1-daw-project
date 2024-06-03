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
    public void addMonster(Monster monster) {

        cardDao.addMonster(CardMapper.toMonsterEntityLanguages(monster));
        //cardDao.addMonster(CardMapper.toMonsterEntity(monster));
    }

    @Override
    public void addSpell(Spell spell) {
        //cardDao.addSpell(CardMapper.toSpellEntity(spell));
        cardDao.addSpell(CardMapper.toSpellEntityLanguages(spell));

    }

    @Override
    public void deleteCard(Integer id) {
        cardDao.deleteCard(id);
    }

    @Override
    public void updateSpell(Spell spell) {
        cardDao.updateSpell(CardMapper.toSpellEntity(spell));
    }

    @Override
    public void updateMonster(Monster monster) {
        cardDao.updateMonster(CardMapper.toMonsterEntity(monster));
    }

}
