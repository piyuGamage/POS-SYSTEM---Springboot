package edu.lk.ijse.posbackend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class OrderDetailDTO {

    @NotBlank(message = "Item ID cannot be blank")
    private String itemId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int qty;

    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private double price;
}
