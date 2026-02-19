package edu.lk.ijse.posbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_id")
    private String itemId;

    private int qty;

    private double price;

    // Many details belong to one order
    @ManyToOne
    @JoinColumn(name = "order_id") // foreign key column
    private Order order;
}
