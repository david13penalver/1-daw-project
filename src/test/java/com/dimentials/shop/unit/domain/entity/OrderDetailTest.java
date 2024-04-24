package com.dimentials.shop.unit.domain.entity;

import com.dimentials.shop.domain.entity.Order;
import com.dimentials.shop.domain.entity.OrderDetail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class OrderDetailTest {
    @Test
    @DisplayName("Test with the constructor of Order")
    public void testOrderConstructor() {
        OrderDetail orderDetail = new OrderDetail(1, null,null, new BigDecimal(0));

        assertAll(
                () -> assertEquals(1, orderDetail.getId()),
                () -> assertEquals(null, orderDetail.getCard()),
                () -> assertEquals(null, orderDetail.getQuantity()),
                () -> assertEquals(new BigDecimal(0), orderDetail.getPrice())
        );
    }
}
