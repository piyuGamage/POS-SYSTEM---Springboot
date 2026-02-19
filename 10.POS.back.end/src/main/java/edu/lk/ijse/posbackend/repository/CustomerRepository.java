package edu.lk.ijse.posbackend.repository;


import edu.lk.ijse.posbackend.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

}
