package edu.lk.ijse.posbackend.repository;

import edu.lk.ijse.posbackend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,String> {
}
