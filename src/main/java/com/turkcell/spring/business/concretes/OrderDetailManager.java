package com.turkcell.spring.business.concretes;

import com.turkcell.spring.business.abstracts.OrderDetailService;
import com.turkcell.spring.entities.concretes.Order;
import com.turkcell.spring.entities.concretes.OrderDetail;
import com.turkcell.spring.entities.concretes.Product;
import com.turkcell.spring.entities.dtos.orderDetail.OrderDetailForAddDto;
import com.turkcell.spring.repositories.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailManager implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailManager(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }
    @Override
    public void addItemsToOrder(Order order, List<OrderDetailForAddDto> items) {
       for (OrderDetailForAddDto item : items){
           OrderDetail orderDetail = OrderDetail.builder()
                   .unitPrice(0)
                   .discount(0)
                   .product(Product.builder().productId(item.getProductId()).build())
                   .quantity(item.getQuantity())
                   .order(Order.builder().orderId(order.getOrderId()).build())
                   .build();
           orderDetailRepository.save(orderDetail);
       }
    }
}
