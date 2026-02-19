package edu.lk.ijse.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @PostMapping("/detail")
    public String saveCustomer() {
        return "Saved";
    }
    @PostMapping()
    public String saveCustomer2(
            @RequestParam("name")String name, @RequestParam("id")String id,@RequestParam("address")String address
    ) {
        return "Saved 1" + name + " " + id + " " + address;
    }

    //query string paameters
    @GetMapping("/search")
    public String searchCustomer(
            @RequestParam("id") String id
    ) {
        return "Customer Found " + id ;
    }
//path variable
    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable("id") String id) {
        return "Customer Deleted" + id;
    }

}
