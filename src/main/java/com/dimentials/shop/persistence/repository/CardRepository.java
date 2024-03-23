package com.dimentials.shop.persistence.repository;

import com.dimentials.shop.domain.entity.Card;

import java.util.List;

public interface CardRepository {
    List<Card> findAll();

    Card findById(int id);
}
