package com.dimentials.shop.unit.domain.entity;

import com.dimentials.shop.domain.entity.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dimentials.shop.domain.entity.Spell;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SpellTest {

    @Test
    @DisplayName("constructor with all parameters")
    public void constructorWithAllParameters(){
        Spell spell = new Spell(1,"Fireball","Spell Description",new BigDecimal(9.50), "test.png", 1);
        assertAll(
                () -> assertEquals(1, spell.getId()),
                () -> assertEquals("Fireball", spell.getName()),
                () -> assertEquals("Spell Description", spell.getDescription()),
                () -> assertEquals(new BigDecimal(9.50), spell.getPrice()),
                () -> assertEquals(1, spell.getMana())
                );
    }
    @Test
    @DisplayName("constructor with all parameters without price")
    public void constructorWithoutPrice(){
        Spell spell = new Spell(1,"Fireball","Spell Description", "test.png",1);
        assertAll(
                () -> assertEquals(1, spell.getId())
                ,() -> assertEquals("Fireball", spell.getName())
                ,() -> assertEquals("Spell Description", spell.getDescription())
                ,() -> assertEquals("test.png", spell.getImgPath())
                ,() -> assertEquals(1, spell.getMana())

        );
    }

    @Test
    void testEmptyConstructor() {
        Spell spell = new Spell();
        assertNotNull(spell);
    }
}
