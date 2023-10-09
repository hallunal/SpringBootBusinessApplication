package com.turkcell.spring.entities.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForOrderAddDto {
    private float unitPrice;
    private short unitsInStock;
}
