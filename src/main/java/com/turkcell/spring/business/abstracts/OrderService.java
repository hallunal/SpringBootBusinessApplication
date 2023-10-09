package com.turkcell.spring.business.abstracts;

import com.turkcell.spring.entities.concretes.Order;
import com.turkcell.spring.entities.dtos.order.*;

import java.util.List;

public interface OrderService {
    void add(OrderForAddDto orderForAddDto);
    List<OrderForListingDto> getAll();
    OrderForGetByIdDto getById(short id);
    void update(short id, OrderForUpdateDto orderForUpdateDto);
    void delete(short id);
    List<Order> findByFreightGreaterThan(float freight);
    public List<OrderForListingWithProductDto> getAllByDto();
}
