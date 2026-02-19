package edu.lk.ijse.posbackend.repository;

import edu.lk.ijse.posbackend.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {
}
