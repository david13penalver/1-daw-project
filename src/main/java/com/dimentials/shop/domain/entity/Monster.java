package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;

public class Monster extends Card {

    private Integer attack;
    private Integer life;
    private String mainType;
    private String secondaryType;

    public Monster(Integer id, String name, String description, Integer attack, Integer life, String mainType, String secondaryType) {
        super(id, name, description);
        this.attack = attack;
        this.life = life;
        this.mainType = mainType;
        this.secondaryType = secondaryType;
    }
    public Monster(Integer id, String name, String description,BigDecimal price, Integer attack, Integer life, String mainType, String secondaryType ) {
        super(id, name, description,price);
        this.attack = attack;
        this.life = life;
        this.mainType = mainType;
        this.secondaryType = secondaryType;
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

    public Monster() {
    }

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

    @Override
    public String toString() {
        return "Monster{" +
                "attack=" + attack +
                ", life=" + life +
                ", mainType='" + mainType + '\'' +
                ", secondaryType='" + secondaryType + '\'' +
                '}';
    }
}
