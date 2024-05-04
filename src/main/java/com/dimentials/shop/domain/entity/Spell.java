package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Spell spell = (Spell) o;
        return Objects.equals(mana, spell.mana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mana);
    }
}
