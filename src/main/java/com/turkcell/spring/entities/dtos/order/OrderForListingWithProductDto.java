package com.turkcell.spring.entities.dtos.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForListingWithProductDto {
    private short orderId;
    private LocalDate orderDate;
    private float freight;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private String shipCountry;
    private String shipName;

    private short productId;
    private String productName;
}
