package com.turkcell.spring.entities.dtos.order;

import com.turkcell.spring.entities.dtos.orderDetail.OrderDetailForAddDto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderForAddDto {
    @PastOrPresent(message = "Sevk tarihi geçmiş veya günümüz tarihi olmalıdır")
    private LocalDate shippedDate;

    @Positive(message = "Kargo ücreti 0'dan büyük olmalıdır")
    private float freight;
    private String shipAddress;
    private String shipCountry;
    private String shipName;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;

    @NotNull(message = "Customer Id alanı boş geçilemez")
    private String customerId;

    @NotNull(message = "Employee Id alanı boş geçilemez")
    private short employeeId;

    @Future
    private LocalDate requiredDate;
    private List<OrderDetailForAddDto> items;
}
