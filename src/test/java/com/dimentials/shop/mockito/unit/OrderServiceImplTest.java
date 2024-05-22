package com.dimentials.shop.mockito.unit;

import com.dimentials.shop.common.exception.ResourceNotFoundException;
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
import static org.junit.jupiter.api.Assertions.*;
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
        @DisplayName("Given user that doesn't exists, should return null")
        void givingUserId3_ShouldReturnNull() {
            when(orderRepositoryMock.findByUserId(3)).thenReturn(null);

            List<Order> resultOrderList = orderService.findByUserId(3);

            assertNull(resultOrderList);
        }

    }

    @Nested
    class FindById {
        @Test
        @DisplayName("Given id1, should return order1")
        void givingId1_ShouldReturnOrder1() {
            when(orderRepositoryMock.findById(1)).thenReturn(order1);

            Order resultOrder = orderService.findById(1);

            assertEquals(order1, resultOrder);
        }

        @Test
        @DisplayName("Given id2, should return order2")
        void givingId2_ShouldReturnOrder2() {
            when(orderRepositoryMock.findById(2)).thenReturn(order2);

            Order resultOrder = orderService.findById(2);

            assertEquals(order2, resultOrder);
        }

        @Test
        @DisplayName("Given id that doesn't exists, should return null")
        void givingId3_ShouldReturnNull() {
            when(orderRepositoryMock.findById(3)).thenReturn(null);
            
            assertThrows(ResourceNotFoundException.class, () -> orderService.findById(3));
        }

    }
}
