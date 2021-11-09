package jpabook.jpashop.repository.query;

import jpabook.jpashop.domain.OrderItem;
import lombok.Getter;

@Getter
public class OrderItemDTO {
    private String itemName;
    private int orderPrice;
    private int count;

    public OrderItemDTO(OrderItem orderItem) {
        this.itemName = orderItem.getItem().getName();
        this.orderPrice = orderItem.getOrderPrice();
        this.count = orderItem.getCount();
    }
}
