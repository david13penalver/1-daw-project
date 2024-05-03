package com.dimentials.shop.unit.domain.entity;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.domain.entity.CartDetail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartDetailTest {
    @Test
    @DisplayName("Constructor test of Cart with all parameters")
    public void testCartConstructorAllParameters() {
        CartDetail cartDetail = new CartDetail(1, null, null, null);
        assertAll(
                () -> assertEquals(1, cartDetail.getId()),
                () -> assertEquals(null, cartDetail.getCard()),
                () -> assertEquals(null, cartDetail.getQuantity()),
                () -> assertEquals(null, cartDetail.getPrice())
        );
    }

    @Test
    @DisplayName("Constructor test of Cart with card and quatity")
    public void testCartConstructor() {
        CartDetail cartDetail = new CartDetail(null, null);
        assertAll(
                () -> assertEquals(null, cartDetail.getCard()),
                () -> assertEquals(null, cartDetail.getQuantity())
        );
    }

    @Test
    void testEmptyConstructor() {
        CartDetail cartDetail = new CartDetail();
        assertNotNull(cartDetail);
    }
}
