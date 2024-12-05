package com.tigran.demo_software_patterns.architectural.architectural.eventdriven;

import com.tigran.demo_software_patterns.architectural.eventdriven.domain.model.Order;
import com.tigran.demo_software_patterns.architectural.eventdriven.repository.EventStoreRepository;
import com.tigran.demo_software_patterns.architectural.eventdriven.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class EventDrivenPatternTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private EventStoreRepository eventRepository;

    @Test
    public void testEventStorageAndOrderReconstruction() {
        // Arrange: Place an order
        String orderId = "order123";
        orderService.placeOrder(orderId);

        // Act: Ship and cancel the order
        orderService.shipOrder(orderId);
        orderService.cancelOrder(orderId);

        // Assert: Verify events were stored in the database
        var events = eventRepository.findByOrderId(orderId);
        assertThat(events).hasSize(3);

        // Assert: Reconstruct order state
        Order order = orderService.getOrder(orderId);
        assertThat(order.getOrderId()).isEqualTo(orderId);
        assertThat(order.getOrderState()).isEqualTo("Cancelled");
    }

}
