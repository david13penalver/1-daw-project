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
            ResultSet resultSet = RawSql.select("SELECT id_card, name_card, description_" + language + ", price, image FROM card WHERE id_card = ?", List.of(id));
            if (!resultSet.next()) {
                return null;
            }
            return CardDaoMapper.toCardEntity(resultSet);
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
    }

//    public void addMonster(MonsterEntity monsterEntity) {
//        try {
//            RawSql.insert(
//                    "INSERT into card (name_card, description_es, description_en, price, image) VALUES (?, ?, ?, ?, ?)",
//                    List.of(monsterEntity.getName(), monsterEntity.getDescription(), monsterEntity.getDescription(), monsterEntity.getPrice(),
//                            monsterEntity.getImgPath()));
//            int lastId = RawSql.select("SELECT LAST_INSERT_ID()", List.of()).getInt(1);
//            RawSql.insert(
//                    "INSERT into monster (id_card, attack, life, main_type_es, main_type_en, secondary_type_es, secondary_type_en) VALUES (?, ?, ?, ?, ?, ?, ?)",
//                    List.of(lastId, monsterEntity.getAttack(), monsterEntity.getLife(),
//                            monsterEntity.getMainType(), monsterEntity.getMainType(), monsterEntity.getSecondaryType(), monsterEntity.getSecondaryType()));
//        } catch (Exception e) {
//            throw new QueryBuilderSQLException(e.getMessage());
//        }
//
//    }

    public void addMonster(MonsterEntity monsterEntity) {
        try {
            Object id = RawSql.insert(
                    "INSERT into card (name_card, description_es, description_en, price, image) VALUES (?, ?, ?, ?, ?)",
                    List.of(monsterEntity.getName(), monsterEntity.getDescription_es(), monsterEntity.getDescription_en(), monsterEntity.getPrice(),
                            monsterEntity.getImgPath()));
            //ResultSet resultSet = RawSql.select("SELECT LAST_INSERT_ID()", List.of());
            //if (resultSet.next()) {
                //int lastId = resultSet.getInt(1);
                RawSql.insert(
                        "INSERT into monster (id_card, attack, life, main_type_es, main_type_en, secondary_type_es, secondary_type_en) VALUES (?, ?, ?, ?, ?, ?, ?)",
                        List.of(id, monsterEntity.getAttack(), monsterEntity.getLife(),
                                monsterEntity.getMainType_es(), monsterEntity.getMainType_en(), monsterEntity.getSecondaryType_es(), monsterEntity.getSecondaryType_en()));
            //}
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
    }

    @Override
    public void addSpell(SpellEntity spellEntity) {
        try {
            Object id = RawSql.insert(
                    "INSERT into card (name_card, description_es, description_en, price, image) VALUES (?, ?, ?, ?, ?);",
                    List.of(spellEntity.getName(), spellEntity.getDescription_es(), spellEntity.getDescription_en(), spellEntity.getPrice(),
                            spellEntity.getImgPath()));
            RawSql.insert(
                    "INSERT into spell (id_card, mana) VALUES (?, ?);",
                    List.of(id, spellEntity.getMana()));
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }

    }

    

    @Override
    public void deleteCard(Integer id) {
        // saca los datos de la base de datos y usa rawsql
        try {
            RawSql.delete("DELETE FROM card WHERE id_card = ?", List.of(id));
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }

    }

    @Override
    public void updateSpell(SpellEntity spellEntity) {
        // update card
        try {
            RawSql.update(
                    "UPDATE card SET name_card = ?, description_es = ?, description_en = ?, price = ?, image = ? WHERE id_card = ?",
                    List.of(spellEntity.getName(), spellEntity.getDescription_es(), spellEntity.getDescription_en(), spellEntity.getPrice(),
                            spellEntity.getImgPath(), spellEntity.getId()));
            RawSql.update(
                    "UPDATE spell SET mana = ? WHERE id_card = ?",
                    List.of(spellEntity.getMana(), spellEntity.getId())
            );
        } catch (Exception e) {
            throw new QueryBuilderSQLException(e.getMessage());
        }
    }

    @Override
    public void updateMonster(MonsterEntity monsterEntity) {
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
    }
}
