package edu.lk.ijse.posbackend.dto;

import jakarta.validation.constraints.*;

public class ItemDTO {

    @NotNull
    private String itemId;

    @NotBlank(message = "Item name cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Item name is incorrect!")
    private String itemName;

    @Min(value = 0, message = "Quantity cannot be negative")
    private int qty;

    @DecimalMin(value = "0.0", inclusive = false, message = "Buy price must be greater than 0")
    private double buyPrice;

    @DecimalMin(value = "0.0", inclusive = false, message = "Sell price must be greater than 0")
    private double sellPrice;

    public ItemDTO() {
    }

    public ItemDTO(String itemId, String itemName, int qty, double buyPrice, double sellPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.qty = qty;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
