package com.dimentials.shop.unit.dao.entity;

import com.dimentials.shop.persistence.dao.entity.CardEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellEntityTest {

    @Test
    @DisplayName("Card constructor with all parameters")
    void testCardConstructorWithAllParameters() {
        CardEntity card = new CardEntity(1, "Card Name", "Card Description", new BigDecimal("10.00"), "test.png");
        assertAll(
                () -> assertEquals(1, card.getId()),
                () -> assertEquals("Card Name", card.getName()),
                () -> assertEquals("Card Description", card.getDescription()),
                () -> assertEquals(new BigDecimal("10.00"), card.getPrice()),
                () -> assertEquals("test.png", card.getImgPath())
        );
    }
}
