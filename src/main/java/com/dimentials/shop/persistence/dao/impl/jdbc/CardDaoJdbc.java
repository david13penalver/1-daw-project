package com.dimentials.shop.persistence.dao.impl.jdbc;

import com.dimentials.shop.common.exception.QueryBuilderSQLException;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.impl.jdbc.mapper.CardDaoMapper;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;
import com.dimentials.shop.persistence.dao.impl.jdbc.rawSql.RawSql;
import org.springframework.context.i18n.LocaleContextHolder;

import java.sql.ResultSet;
import java.util.List;
import java.util.Locale;

public class CardDaoJdbc implements CardDao {
    @Override
    public List<CardEntity> findAll() {
        //Locale currentLocale = LocaleContextHolder.getLocale();
        //String language = currentLocale.getLanguage();
        try {
            ResultSet resultSet = RawSql.select("SELECT * FROM card", List.of());
            assert resultSet != null;
            return CardDaoMapper.toCardList(resultSet);
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
    }

    @Override
    public CardEntity findById(Integer id) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String language = currentLocale.getLanguage();
        try {
            ResultSet resultSet = RawSql.select("SELECT * FROM card WHERE id_card = ?", List.of(id));
            if (!resultSet.next()) {
                return null;
            }
            return CardDaoMapper.toCardEntity(resultSet);
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
//        try {
//            ResultSet resultSet = DB
//                    .table("card")
//                    .select("id_card", "name_card", "description_" + language, "price", "image")
//                    .find(id);
//            return CardDaoMapper.toCardEntity(resultSet);
//        } catch (Exception e) {
//            throw new QueryBuilderSQLException(e.getMessage());
//        }
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
