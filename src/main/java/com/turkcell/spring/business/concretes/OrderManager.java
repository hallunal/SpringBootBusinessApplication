package com.turkcell.spring.business.concretes;

import com.turkcell.spring.business.abstracts.OrderDetailService;
import com.turkcell.spring.business.abstracts.OrderService;
import com.turkcell.spring.entities.concretes.Customer;
import com.turkcell.spring.entities.concretes.Employee;
import com.turkcell.spring.entities.concretes.Order;
import com.turkcell.spring.entities.dtos.order.*;
import com.turkcell.spring.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;

    public OrderManager(OrderRepository orderRepository, OrderDetailService orderDetailService) {
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
    }

    @Override
    @Transactional
    public void add(OrderForAddDto orderForAddDto) {
        Order order = Order.builder()
                .customer(Customer.builder().customerId(orderForAddDto.getCustomerId()).build())
                .employee(Employee.builder().employeeId(orderForAddDto.getEmployeeId()).build())
                .shippedDate(orderForAddDto.getShippedDate())
                .orderDate(LocalDate.now())
                .shipCity(orderForAddDto.getShipCity())
                .shipAddress(orderForAddDto.getShipAddress())
                .shipName(orderForAddDto.getShipName())
                .shipRegion(orderForAddDto.getShipRegion())
                .requiredDate(orderForAddDto.getRequiredDate())
                .shipPostalCode(orderForAddDto.getShipPostalCode())
                .build();
        order = orderRepository.save(order);
        //Bu satırdan sonra order'ın id alanı oluşmuş olacak.Yani artık order_details tablosuna order_id verebilecek haldeyiz.
        orderDetailService.addItemsToOrder(order, orderForAddDto.getItems());
    }

    @Override
    public List<OrderForListingDto> getAll() {
        return null;
    }

    @Override
    public OrderForGetByIdDto getById(short id) {
        return null;
    }

    @Override
    public void update(short id, OrderForUpdateDto orderForUpdateDto) {

    }

    @Override
    public void delete(short id) {

    }

    @Override
    public List<Order> findByFreightGreaterThan(float freight) {
        return null;
    }

    @Override
    public List<OrderForListingWithProductDto> getAllByDto() {
        return orderRepository.getOrderForListing();
    }
}
