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
        // Locale currentLocale = LocaleContextHolder.getLocale();
        // String language = currentLocale.getLanguage();
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
        // try {
        // ResultSet resultSet = DB
        // .table("card")
        // .select("id_card", "name_card", "description_" + language, "price", "image")
        // .find(id);
        // return CardDaoMapper.toCardEntity(resultSet);
        // } catch (Exception e) {
        // throw new QueryBuilderSQLException(e.getMessage());
        // }
    }

    @Override
    public MonsterEntity addMonster(MonsterEntity monsterEntity) {
        try {
            RawSql.insert(
                    "INSERT into card (name_card, description, price, image) VALUES (?, ?, ?, ?); INSERT into monster (attack, life, primary_type, secondary_type) VALUES (SELECT LAST_INSERT_ID(), ?, ?, ?, ?)",
                    List.of(monsterEntity.getName(), monsterEntity.getDescription(), monsterEntity.getPrice(),
                            monsterEntity.getImgPath(), monsterEntity.getAttack(), monsterEntity.getLife(),
                            monsterEntity.getMainType(), monsterEntity.getSecondaryType()));
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
        return null;
    }

    @Override
    public SpellEntity addSpell(SpellEntity spellEntity) {
        try {
            RawSql.insert(
                    "INSERT into card (name_card, description, price, image) VALUES (?, ?, ?, ?); INSERT into spell (mana) VALUES (SELECT LAST_INSERT_ID(), ?)",
                    List.of(spellEntity.getName(), spellEntity.getDescription(), spellEntity.getPrice(),
                            spellEntity.getImgPath(), spellEntity.getId(), spellEntity.getMana()));
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
        return null;

    }

    

    @Override
    public CardEntity deleteCard(Integer id) {
        // saca los datos de la base de datos y usa rawsql
        try {
            RawSql.delete("DELETE FROM card WHERE id_card = ?", List.of(id));
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
        return null;

    }

    @Override
    public SpellEntity updateSpell(SpellEntity spellEntity) {
        // update card
        try {
            RawSql.update(
                    "UPDATE card SET name_card = ?, description_es = ?, price = ?, image = ? WHERE id_card = ?",
                    List.of(spellEntity.getName(), spellEntity.getDescription(), spellEntity.getPrice(),
                            spellEntity.getImgPath(), spellEntity.getId()));
            RawSql.update(
                    "UPDATE spell SET mana = ? WHERE id_card = ?",
                    List.of(spellEntity.getMana(), spellEntity.getId())
            );
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
        return null;
    }

    @Override
    public MonsterEntity updateMonster(MonsterEntity monsterEntity) {
        // saca los datos de la base de datos y usa rawsql
        try {
            RawSql.update(
                    "UPDATE card SET name_card = ?, description_es = ?, price = ?, image = ? WHERE id_card = ?",
                    List.of(monsterEntity.getName(), monsterEntity.getDescription(), monsterEntity.getPrice(),
                            monsterEntity.getImgPath(), monsterEntity.getId()
                    )
            );
            RawSql.update(
                    "UPDATE monster SET attack = ?, life = ?, main_type_es = ?, secondary_type_es = ? WHERE id_card = ?",
                    List.of(monsterEntity.getAttack(), monsterEntity.getLife(), monsterEntity.getMainType(),
                            monsterEntity.getSecondaryType(), monsterEntity.getId()
                    )
            );
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
        return null;
    }
}
