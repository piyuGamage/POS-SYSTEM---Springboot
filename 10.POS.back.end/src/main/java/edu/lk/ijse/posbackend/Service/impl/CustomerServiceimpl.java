package edu.lk.ijse.posbackend.Service.impl;

import edu.lk.ijse.posbackend.Entity.Customer;
import edu.lk.ijse.posbackend.Service.CustomerService;
import edu.lk.ijse.posbackend.dto.CustomerDTO;
import edu.lk.ijse.posbackend.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
//        if (customerDTO == null) {
////            throw  new NullPointerException("customer dto null");
//        }
      customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(c -> new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getPhone()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

        if (customerRepository.existsById(customerDTO.getId())) {

            customerRepository.save(
                    modelMapper.map(customerDTO, Customer.class)
            );

        } else {
            throw new RuntimeException("Customer not found!");
        }
    }


    @Override
    public CustomerDTO getCustomerById(String id) {
        return customerRepository.findById(id)
                .map(c -> new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getPhone()))
                .orElseThrow(() -> new RuntimeException("Customer not found!"));
    }



}
