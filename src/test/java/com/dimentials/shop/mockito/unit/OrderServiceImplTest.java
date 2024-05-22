package com.dimentials.shop.mockito.unit;

import com.dimentials.shop.domain.entity.Order;
import com.dimentials.shop.domain.service.OrderService;
import com.dimentials.shop.domain.service.impl.OrderServiceImpl;
import com.dimentials.shop.persistence.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
    @Mock
    private OrderRepository orderRepositoryMock;
    @InjectMocks
    private OrderServiceImpl orderService;

    private final Order order1 = new Order(1);
    private final Order order2 = new Order(1);
    private final List<Order> orderList1 = List.of(order1, order2);
    private final List<Order> orderList2 = List.of(order1, order2);

    @Nested
    class FindByUserId {
        @Test
        @DisplayName("Given user1, should return list1")
        void givingUserId1_ShouldReturnList1() {
            when(orderRepositoryMock.findByUserId(1)).thenReturn(orderList1);

            List<Order> resultOrderList = orderService.findByUserId(1);

            assertEquals(orderList1, resultOrderList);
        }

        @Test
        @DisplayName("Given user2, should return list2")
        void givingUserId2_ShouldReturnList2() {
            when(orderRepositoryMock.findByUserId(2)).thenReturn(orderList2);

            List<Order> resultOrderList = orderService.findByUserId(2);

            assertEquals(orderList1, resultOrderList);
        }

        @Test
        @DisplayName("Given user that doesn't existe, should return null")
        void givingUserId3_ShouldReturnNull() {
            when(orderRepositoryMock.findByUserId(3)).thenReturn(null);

            List<Order> resultOrderList = orderService.findByUserId(3);

            assertNull(resultOrderList);
        }

    }

    @Nested
    class FindById {

    }
}
