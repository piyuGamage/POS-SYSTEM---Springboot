package edu.lk.ijse.posbackend.Service;

import edu.lk.ijse.posbackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO);
    public List<CustomerDTO> getCustomers();
    void deleteCustomerById( String id);
    void updateCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerById(String id);
}


