package com.dimentials.shop.unit.domain.entity;

import com.dimentials.shop.domain.entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @Test
    @DisplayName("Test with the constructor of Order")
    public void testOrderConstructor() {
        com.dimentials.shop.domain.entity.Order order = new Order(1, null, null, new BigDecimal(0));

        assertAll(
                () -> assertEquals(1, order.getId()),
                () -> assertEquals(null, order.getClient()),
                () -> assertEquals(null, order.getOrderDetailList()),
                () -> assertEquals(new BigDecimal(0), order.getTotal())
        );
    }
}
