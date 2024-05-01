package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;

public class Spell extends Card {

    private Integer mana;

    public Spell(Integer id, String name, String description, BigDecimal price, String imgPath, Integer mana) {
        super(id, name, description, price, imgPath);
        this.mana = mana;
    }

    public Spell(Integer mana) {
        this.mana = mana;
    }

    public Spell(Integer id, String name, String description, String imgPath, Integer mana) {
        super(id, name, description, imgPath);
        this.mana = mana;
    }

    public Spell() {
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }
}
