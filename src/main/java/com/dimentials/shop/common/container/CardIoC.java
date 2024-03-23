package com.dimentials.shop.common.container;

import com.dimentials.shop.domain.service.CardService;
import com.dimentials.shop.domain.service.impl.CardServiceImpl;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.impl.CardDaoImpl;
import com.dimentials.shop.persistence.repository.CardRepository;
import com.dimentials.shop.persistence.repository.impl.CardRepositoryImpl;

public class CardIoC {

    private static CardDao cardDao;
    private static CardRepository cardRepository;
    private static CardService cardService;

    public static CardDao getCardDao() {
        if (cardDao == null) {
            cardDao = new CardDaoImpl();
        }
        return cardDao;
    }

    public static CardRepository getCardRepository() {
        if (cardRepository == null) {
            cardRepository = new CardRepositoryImpl(getCardDao());
        }
        return cardRepository;
    }

    public static CardService getCardService() {
        if (cardService == null) {
            cardService = new CardServiceImpl(getCardRepository());
        }
        return cardService;
    }
}
