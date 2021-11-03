package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ManyToOne, OneToOne
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {
    private final OrderRepository orderRepository;


    @GetMapping("/api/v1/sample-orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            // Lazy 강제 초기화
            order.getMember().getName();
            order.getDelivery().getAddress();
        }
        return all;
    }
}
