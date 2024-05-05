package com.dimentials.shop.persistence.dao;

import com.dimentials.shop.persistence.dao.entity.CardEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CardDaoMapper {
    public static List<CardEntity> toCardList(List<ResultSet> resultSetList) {
        if (resultSetList == null)
            return null;
        List<CardEntity> cardEntityList = new ArrayList<>();
        for (ResultSet resultSet : resultSetList) {
            cardEntityList.add(toCardEntity(resultSet));
        }
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
