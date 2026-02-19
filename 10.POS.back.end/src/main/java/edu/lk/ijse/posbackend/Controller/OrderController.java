package edu.lk.ijse.posbackend.Controller;

import edu.lk.ijse.posbackend.Service.OrderService;
import edu.lk.ijse.posbackend.dto.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody @Valid OrderDTO orderDTO) {
        orderService.placeOrder(orderDTO);
        return ResponseEntity.ok("Order Placed Successfully!");
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order Deleted Successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable String id,
                                              @RequestBody @Valid OrderDTO orderDTO) {
        orderDTO.setOrderId(id);
        orderService.updateOrder(orderDTO);
        return ResponseEntity.ok("Order Updated Successfully!");
    }
}
