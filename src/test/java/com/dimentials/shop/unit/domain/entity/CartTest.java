package com.dimentials.shop.unit.domain.entity;

import com.dimentials.shop.domain.entity.Cart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {
    @Test
    @DisplayName("Constructor test of Cart")
    public void testCartConstructor() {
        Cart cart = new Cart(1, null, null, null);
        assertAll(
                () -> assertEquals(1, cart.getId()),
                () -> assertEquals(null, cart.getClient()),
//                () -> assertEquals(null, cart.getCartDetailList()),
                () -> assertEquals(null, cart.getTotal())
        );

        }
}
