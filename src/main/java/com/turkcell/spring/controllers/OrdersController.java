package com.turkcell.spring.controllers;

import com.turkcell.spring.business.abstracts.OrderService;
import com.turkcell.spring.entities.dtos.order.OrderForAddDto;
import com.turkcell.spring.entities.dtos.order.OrderForListingWithProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("add")
    public void add(@RequestBody OrderForAddDto request){
        orderService.add(request);
    }

    @GetMapping("getOrderWithProducts")
    public List<OrderForListingWithProductDto> getOrderWithProducts() {
        return orderService.getAllByDto();
    }

}
