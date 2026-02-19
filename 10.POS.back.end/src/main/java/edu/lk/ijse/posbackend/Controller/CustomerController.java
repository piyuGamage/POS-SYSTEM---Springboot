package edu.lk.ijse.posbackend.Controller;

import edu.lk.ijse.posbackend.dto.CustomerDTO;
import edu.lk.ijse.posbackend.Service.CustomerService;
import edu.lk.ijse.posbackend.util.APIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<APIResponse<String>> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(
                new APIResponse<>(201, "Customer saved successfully", null),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<CustomerDTO>>> getCustomers() {
        List<CustomerDTO> customers = customerService.getCustomers();
        return new ResponseEntity<>(
                new APIResponse<>(200, "Customers retrieved successfully", customers),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<CustomerDTO>> getCustomerById(@PathVariable String id) {
        CustomerDTO customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(
                new APIResponse<>(200, "Customer retrieved successfully", customer),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<String>> updateCustomer(@PathVariable String id,
                                                              @RequestBody @Valid CustomerDTO customerDTO) {
        customerDTO.setId(id);
        customerService.updateCustomer(customerDTO);
        return new ResponseEntity<>(
                new APIResponse<>(200, "Customer updated successfully", null),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<String>> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(
                new APIResponse<>(200, "Customer deleted successfully", null),
                HttpStatus.OK
        );
    }
}
