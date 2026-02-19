package edu.lk.ijse.posbackend.Service;

import edu.lk.ijse.posbackend.dto.OrderDTO;
import java.util.List;

public interface OrderService {

    void placeOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(String orderId);
    void deleteOrder(String orderId);
    void updateOrder(OrderDTO orderDTO);
}
