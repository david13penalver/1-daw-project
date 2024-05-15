package com.dimentials.shop.persistence.dao.impl.jdbc.mapper;

import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;

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

    public static CardEntity toCardEntity(ResultSet resultSet) {

        if (resultSet == null) {
            return null;
        }
        CardEntity cardEntity = new CardEntity();
        try {
            if (resultSet.next()) {
                cardEntity.setId(resultSet.getInt("id_card"));
                cardEntity.setName(resultSet.getString("name_card"));
                cardEntity.setDescription(resultSet.getString("description_es"));
                cardEntity.setPrice(resultSet.getBigDecimal("price"));
                cardEntity.setImgPath(resultSet.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardEntity;
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
