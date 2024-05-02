package com.dimentials.shop.persistence.dao.impl.jdbc.mapper;

import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardEntityMapper {

    public static CardEntity toCardEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new CardEntity(
                Integer.valueOf(resultSet.getInt("id")),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getBigDecimal("price"),
                resultSet.getString("imgPath"));

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


