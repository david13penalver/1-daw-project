package com.dimentials.shop.persistence.repository.impl;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.dao.CardDao;
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
    public Card findById(int id) {
        return CardMapper.toCard(cardDao.findById(id));
    }
}
