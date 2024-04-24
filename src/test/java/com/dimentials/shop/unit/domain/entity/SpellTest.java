package com.dimentials.shop.unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dimentials.shop.domain.entity.Spell;

import java.math.BigDecimal;

public class SpellTest {

    @Test
    @DisplayName("constructor with all parameters")
    public void constructorWithAllParameters(){
        Spell spell = new Spell(1,"Fireball","Spell Description",new BigDecimal(9.50), "test.png", "Mana");
        assertAll(
                () -> assertEquals(1, spell.getId()),
                () -> assertEquals("Fireball", spell.getName()),
                () -> assertEquals("Spell Description", spell.getDescription()),
                () -> assertEquals(new BigDecimal(9.50), spell.getPrice()),
                () -> assertEquals("Mana", spell.getMana())
                );
    }
    @Test
    @DisplayName("constructor with all parameters without price")
    public void constructorWithoutPrice(){
        Spell spell = new Spell(1,"Fireball","Spell Description", "test.png","Mana");
        assertAll(
                () -> assertEquals(1, spell.getId())
                ,() -> assertEquals("Fireball", spell.getName())
                ,() -> assertEquals("Spell Description", spell.getDescription())
                ,() -> assertEquals("test.png", spell.getImgPath())
                ,() -> assertEquals("Mana", spell.getMana())

        );
    }
}
