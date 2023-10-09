package com.turkcell.spring.repositories;

import com.turkcell.spring.entities.concretes.Order;
import com.turkcell.spring.entities.dtos.order.OrderForListingWithProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Short> {
    @Query(value = "Select new com.turkcell.spring.entities.dtos.order.OrderForListingWithProductDto" +
            "(o.orderId,o.orderDate,o.freight,o.requiredDate,o.shippedDate,o.shipCountry,o.shipName, p.productId,p.productName) " +
            "from Order o join o.orderDetails od " +
            "join od.product p" )
    List<OrderForListingWithProductDto> getOrderForListing();
}
