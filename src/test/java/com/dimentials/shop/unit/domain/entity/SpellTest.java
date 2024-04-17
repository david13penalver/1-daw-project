package com.dimentials.shop.unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dimentials.shop.domain.entity.Spell;

public class SpellTest {
    @Test
    @DisplayName("constructor with all parameters")
    public void constructorWithAllParameters(){
        Spell spell = new Spell(1,"Fireball","Spell Description","Mana");
        assertAll(
                () -> assertEquals(1, spell.getId())
                ,() -> assertEquals("Fireball", spell.getName())
                ,() -> assertEquals("Spell Description", spell.getDescription())
                ,() -> assertEquals("Mana", spell.getMana())

        );
    }
}
