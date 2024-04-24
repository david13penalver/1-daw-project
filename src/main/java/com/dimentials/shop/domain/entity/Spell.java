package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;

public class Spell extends Card {

    private String mana;

    public Spell(Integer id, String name, String description, BigDecimal price, String imgPath, String mana) {
        super(id, name, description, price, imgPath);
        this.mana = mana;
    }

    public Spell(Integer id, String name, String description, String imgPath, String mana) {
        super(id, name, description, imgPath);
        this.mana = mana;
    }

    public Spell(String mana) {
        this.mana = mana;
    }

    public Spell() {
    }

    public String getMana() {
        return mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }
}
