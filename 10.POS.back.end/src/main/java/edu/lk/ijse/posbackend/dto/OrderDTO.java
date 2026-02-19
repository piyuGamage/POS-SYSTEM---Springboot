package edu.lk.ijse.posbackend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    @NotBlank(message = "Order ID cannot be blank")
    private String orderId;

    @NotBlank(message = "Customer ID cannot be blank")
    private String customerId;

    @NotBlank(message = "Payment type cannot be blank")
    @Pattern(regexp = "CASH|CARD", message = "Payment type must be CASH or CARD")
    private String paymentType;

    @NotEmpty(message = "Order details cannot be empty")
    @Valid
    private List<OrderDetailDTO> orderDetails;

    @DecimalMin(value = "0.01", message = "Total must be greater than 0")
    private double total;
}
