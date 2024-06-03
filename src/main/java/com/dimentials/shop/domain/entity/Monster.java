package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Monster extends Card {

    private Integer attack;
    private Integer life;
    private String mainType;
    private String mainType_es;
    private String mainType_en;
    private String secondaryType;
    private String secondaryType_es;
    private String secondaryType_en;

    public Monster(Integer id, String name, String description, BigDecimal price, String imgPath, Integer attack, Integer life, String mainType, String secondaryType) {
        super(id, name, description, price, imgPath);
        this.attack = attack;
        this.life = life;
        this.mainType = mainType;
        this.secondaryType = secondaryType;
    }

    public Monster(Integer id, String name, String description_es, String getDescription_en, BigDecimal price, String imgPath, Integer attack, Integer life, String mainType_es, String mainType_en, String secondaryType_es, String secondaryType_en) {
        super(id, name, description_es, getDescription_en, price, imgPath);
        this.attack = attack;
        this.life = life;
        this.mainType_es = mainType_es;
        this.mainType_en = mainType_en;
        this.secondaryType_es = secondaryType_es;
        this.secondaryType_en = secondaryType_en;
    }

    public Monster(Integer attack, Integer life, String mainType, String secondaryType) {
        this.attack = attack;
        this.life = life;
        this.mainType = mainType;
        this.secondaryType = secondaryType;
    }

    public Monster(Integer id, String name, String description, String imgPath, Integer attack, Integer life, String mainType, String secondaryType) {
        super(id, name, description, imgPath);
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

    public String getMainType_es() {
        return mainType_es;
    }

    public void setMainType_es(String mainType_es) {
        this.mainType_es = mainType_es;
    }

    public String getMainType_en() {
        return mainType_en;
    }

    public void setMainType_en(String mainType_en) {
        this.mainType_en = mainType_en;
    }

    public String getSecondaryType_es() {
        return secondaryType_es;
    }

    public void setSecondaryType_es(String secondaryType_es) {
        this.secondaryType_es = secondaryType_es;
    }

    public String getSecondaryType_en() {
        return secondaryType_en;
    }

    public void setSecondaryType_en(String secondaryType_en) {
        this.secondaryType_en = secondaryType_en;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monster monster = (Monster) o;
        return Objects.equals(attack, monster.attack) && Objects.equals(life, monster.life) && Objects.equals(mainType, monster.mainType) && Objects.equals(secondaryType, monster.secondaryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attack, life, mainType, secondaryType);
    }
}
