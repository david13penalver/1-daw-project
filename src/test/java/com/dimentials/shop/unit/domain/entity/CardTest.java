package com.dimentials.shop.unit.domain.entity;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dimentials.shop.domain.entity.Card;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    @DisplayName("Card constructor with all parameters")
    public void testCardConstructorWithAllParameters() {
        Card card = new Card(1, "Card Name", "Card Description", new BigDecimal("10.00"), "test.png");
        assertAll(
                () -> assertEquals(1, card.getId()),
                () -> assertEquals("Card Name", card.getName()),
                () -> assertEquals("Card Description", card.getDescription()),
                () -> assertEquals(new BigDecimal("10.00"), card.getPrice()),
                () -> assertEquals("test.png", card.getImgPath())
        );
    }

    @Test
    @DisplayName("Card constructor with id, name and description")
    public void testCardConstructorWithIdNameAndDescription() {
        Card card = new Card(1, "Card Name", "Card Description", "test.png");
        assertAll(
                () -> assertEquals(1, card.getId()),
                () -> assertEquals("Card Name", card.getName()),
                () -> assertEquals("Card Description", card.getDescription()),
                () -> assertEquals("test.png", card.getImgPath())
        );

    }

    @Test
    void testEmptyConstructor() {
        Card card = new Card();
        assertNotNull(card);
    }
}
