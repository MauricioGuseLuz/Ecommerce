package com.ecommerce.api.dto;

import com.ecommerce.api.entities.OrderStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class OrderDto {

    private Long id;
    @NotNull(message = "Data do pedido é obrigatório")
    @PastOrPresent(message = "Data do pedido deve ser passada")
    private Instant moment;

    @Pattern(regexp = "^(WAITING_PAYMENT|PAID|SHIPPED|CANCELLED|DELIVED)$", message = "Status deve ser uma das opções: DELIVERED, WAITING_PAYMENT, PAID, SHIPPED, CANCELLED")
    @NotBlank(message = "Status é obrigatório")
    private OrderStatus status;

    private UserDto user;
    private PaymentDto payment;

    @NotEmpty(message = "Obrigatório selecionar pelo menos um produto")
    private List<OrderItemDto> orderItems;

}
