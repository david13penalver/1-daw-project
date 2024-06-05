package com.dimentials.shop.persistence.dao.entity;


import java.math.BigDecimal;
import java.util.Objects;

public class SpellEntity extends CardEntity{
    private Integer mana;

    public SpellEntity() {

    }

    public Integer getMana() {
        return mana;
    }
    
    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public SpellEntity(Integer id, String name, String description, BigDecimal price, String imgPath, Integer mana) {
        super(id, name, description, price, imgPath);
        this.mana = mana;
    }

    public SpellEntity(Integer id, String name, String description_es, String getDescription_en, BigDecimal price, String imgPath, Integer mana) {
        super(id, name, description_es, getDescription_en, imgPath, price);
        this.mana = mana;
    }

    public SpellEntity(Integer id, String name, String description, Integer mana) {
        super(id, name, description);
        this.mana = mana;
    }

    public SpellEntity(Integer mana) {
        this.mana = mana;
    }
}
