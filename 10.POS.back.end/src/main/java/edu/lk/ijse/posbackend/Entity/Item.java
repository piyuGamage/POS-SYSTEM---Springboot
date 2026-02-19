package edu.lk.ijse.posbackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {

    @Id
    private String itemId;

    private String itemName;
    private int qty;
    private double buyPrice;
    private double sellPrice;
}
