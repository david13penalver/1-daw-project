package com.dimentials.shop.persistence.dao.impl.jdbc.mapper;

import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDaoMapper {
    public static List<CardEntity> toCardList(ResultSet resultSetList) throws SQLException {
        List<CardEntity> cardEntityList = new ArrayList<>();
        while (resultSetList.next()) {
            cardEntityList.add(toCardEntity(resultSetList));
        }
        return cardEntityList;
    }

    public static CardEntity toCardEntity(ResultSet resultSet) throws SQLException {

        Integer id = resultSet.getInt("id_card");
        String name = resultSet.getString("name_card");
        String description = resultSet.getString("description_es");
        BigDecimal price = resultSet.getBigDecimal("price");
        String imgPath = resultSet.getString("image");
        return new CardEntity(id, name, description, price, imgPath);


    }

    public static MonsterEntity toMonsterEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new MonsterEntity(
                Integer.valueOf(resultSet.getInt("id")),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getBigDecimal("price"),
                resultSet.getString("imgPath"),
                Integer.valueOf(resultSet.getInt("attack")),
                Integer.valueOf(resultSet.getInt("life")),
                resultSet.getString("mainType"),
                resultSet.getString("secondaryType"));
    }
    public static MonsterEntity toMonsterEntityLanguages(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new MonsterEntity(
                Integer.valueOf(resultSet.getInt("id")),
                resultSet.getString("name"),
                resultSet.getString("description_es"),
                resultSet.getString("description_en"),
                resultSet.getBigDecimal("price"),
                resultSet.getString("imgPath"),
                Integer.valueOf(resultSet.getInt("attack")),
                Integer.valueOf(resultSet.getInt("life")),
                resultSet.getString("mainType_es"),
                resultSet.getString("mainType_en"),
                resultSet.getString("secondaryType_es"),
                resultSet.getString("secondaryType_en"));
    }

    public static SpellEntity toSpellEntity(ResultSet resultSet)throws SQLException{
        if (resultSet == null) {
            return null;
        }
        return new SpellEntity(
                Integer.valueOf(resultSet.getInt("id")),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getBigDecimal("price"),
                resultSet.getString("imgPath"),
                Integer.valueOf(resultSet.getInt("mana")));

    }
}
