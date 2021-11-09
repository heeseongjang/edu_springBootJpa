package jpabook.jpashop.repository.query;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.service.query.OrderQueryService;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderDTO {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItemDTO> orderItems;

    public OrderDTO(Order order) {
        this.orderId = order.getId();
        this.name = order.getMember().getName(); // LAZY 초기화
        this.orderDate = order.getOrderDate();
        this.orderStatus = order.getStatus();
        this.address = order.getDelivery().getAddress(); // LAZY 초기화
//            order.getOrderItems().forEach(o -> o.getItem().getName());
        this.orderItems = order.getOrderItems().stream()
                .map(o -> new OrderItemDTO(o))
                .collect(Collectors.toList());
    }
}