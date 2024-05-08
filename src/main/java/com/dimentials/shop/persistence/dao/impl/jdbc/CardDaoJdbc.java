package com.dimentials.shop.persistence.dao.impl.jdbc;

import com.dimentials.shop.common.exception.QueryBuilderSQLException;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.impl.jdbc.mapper.CardDaoMapper;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;
import com.dimentials.shop.persistence.dao.impl.jdbc.rawSql.RawSql;

import java.sql.ResultSet;
import java.util.List;

public class CardDaoJdbc implements CardDao {
    @Override
    public List<CardEntity> findAll() {
        //Locale currentLocale = LocaleContextHolder.getLocale();
        //String language = currentLocale.getLanguage();
        try {
            System.out.printf("hola");
            ResultSet resultSet = RawSql.select("SELECT * FROM card", null);
            return CardDaoMapper.toCardList(resultSet);
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
    }

    @Override
    public CardEntity findById(Integer id) {
        return null;
    }

    @Override
    public MonsterEntity addMonster(MonsterEntity monsterEntity) {
        return null;
    }

    @Override
    public SpellEntity addSpell(SpellEntity spellEntity) {
        return null;
    }

    @Override
    public CardEntity deleteCard(Integer id) {
        return null;
    }

    @Override
    public SpellEntity updateSpell(SpellEntity spellEntity) {
        return null;
    }

    @Override
    public MonsterEntity updateMonster(MonsterEntity monsterEntity) {
        return null;
    }
}
