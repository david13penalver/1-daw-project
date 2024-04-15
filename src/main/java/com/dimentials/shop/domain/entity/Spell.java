package com.dimentials.shop.domain.entity;

public class Spell extends Card {

    private String mana;

    public Spell(Integer id, String name, String description, String mana) {
        super(id, name, description);
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
