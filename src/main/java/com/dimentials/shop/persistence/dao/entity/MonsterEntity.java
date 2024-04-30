package com.dimentials.shop.persistence.dao.entity;


import java.math.BigDecimal;
import java.util.Objects;

public class MonsterEntity extends CardEntity{

    private Integer attack;
    private Integer life;
    private String mainType;
    private String secondaryType;

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(String secondaryType) {
        this.secondaryType = secondaryType;
    }

    public MonsterEntity(Integer id, String name, String description, BigDecimal price, String imgPath, Integer attack, Integer life, String mainType, String secondaryType) {
        super(id, name, description, price, imgPath);
        this.attack = attack;
        this.life = life;
        this.mainType = mainType;
        this.secondaryType = secondaryType;
    }


    
}
