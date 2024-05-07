package com.dimentials.shop.persistence.dao;

import com.dimentials.shop.persistence.dao.entity.CardEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDaoMapper {
    public static List<CardEntity> toCardList(ResultSet resultSetList) throws SQLException {
        if (resultSetList == null)
            return null;
        List<CardEntity> cardEntityList = new ArrayList<>();
        while (!resultSetList.next()) {
            cardEntityList.add(toCardEntity(resultSetList));
        }
        return cardEntityList;
    }

    public static CardEntity toCardEntity(ResultSet resultSet) {
        if (resultSet == null)
            return null;
        CardEntity cardEntity = new CardEntity();
        try {
            cardEntity.setId(resultSet.getInt("id"));
            cardEntity.setName(resultSet.getString("name"));
            cardEntity.setDescription(resultSet.getString("description"));
            cardEntity.setImgPath(resultSet.getString("imgPath"));
            cardEntity.setPrice(resultSet.getBigDecimal("price"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
