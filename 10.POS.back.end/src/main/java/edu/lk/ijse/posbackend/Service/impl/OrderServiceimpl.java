package edu.lk.ijse.posbackend.Service.impl;

import edu.lk.ijse.posbackend.Entity.Item;
import edu.lk.ijse.posbackend.Entity.Order;
import edu.lk.ijse.posbackend.Entity.OrderDetail;
import edu.lk.ijse.posbackend.Service.OrderService;
import edu.lk.ijse.posbackend.dto.OrderDTO;
import edu.lk.ijse.posbackend.dto.OrderDetailDTO;
import edu.lk.ijse.posbackend.repository.ItemRepository;
import edu.lk.ijse.posbackend.repository.OrderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceimpl implements OrderService {

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setCustomerId(orderDTO.getCustomerId());
        order.setPaymentType(orderDTO.getPaymentType());
        order.setTotal(orderDTO.getTotal());

        List<OrderDetail> details = orderDTO.getOrderDetails()
                .stream()
                .map(d -> {

                    Item item = itemRepository.findById(d.getItemId())
                            .orElseThrow(() -> new RuntimeException("Item not found: " + d.getItemId()));

                    if (item.getQty() < d.getQty()) {
                        throw new RuntimeException("Not enough stock for item: " + d.getItemId());
                    }

                    item.setQty(item.getQty() - d.getQty());
                    itemRepository.save(item);

                    OrderDetail od = new OrderDetail();
                    od.setItemId(d.getItemId());
                    od.setQty(d.getQty());
                    od.setPrice(d.getPrice());
                    return od;
                })
                .collect(Collectors.toList());

        order.setOrderDetails(details);
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void deleteOrder(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found!"));


        for (OrderDetail detail : order.getOrderDetails()) {
            Item item = itemRepository.findById(detail.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found: " + detail.getItemId()));

            item.setQty(item.getQty() + detail.getQty());
            itemRepository.save(item);
        }

        orderRepository.delete(order);
    }

    @Override
    @Transactional
    public void updateOrder(OrderDTO orderDTO) {
        if (orderRepository.existsById(orderDTO.getOrderId())) {
            deleteOrder(orderDTO.getOrderId()); // restore old qty
            placeOrder(orderDTO);               // place new order and reduce qty
        } else {
            throw new RuntimeException("Order not found!");
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> {
                    OrderDTO dto = new OrderDTO();
                    dto.setOrderId(order.getOrderId());
                    dto.setCustomerId(order.getCustomerId());
                    dto.setPaymentType(order.getPaymentType());
                    dto.setTotal(order.getTotal());

                    List<OrderDetailDTO> detailDTOs = order.getOrderDetails()
                            .stream()
                            .map(d -> {
                                OrderDetailDTO odto = new OrderDetailDTO();
                                odto.setItemId(d.getItemId());
                                odto.setQty(d.getQty());
                                odto.setPrice(d.getPrice());
                                return odto;
                            })
                            .collect(Collectors.toList());

                    dto.setOrderDetails(detailDTOs);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found!"));

        OrderDTO dto = new OrderDTO();
        dto.setOrderId(order.getOrderId());
        dto.setCustomerId(order.getCustomerId());
        dto.setPaymentType(order.getPaymentType());
        dto.setTotal(order.getTotal());

        List<OrderDetailDTO> detailDTOs = order.getOrderDetails()
                .stream()
                .map(d -> {
                    OrderDetailDTO odto = new OrderDetailDTO();
                    odto.setItemId(d.getItemId());
                    odto.setQty(d.getQty());
                    odto.setPrice(d.getPrice());
                    return odto;
                })
                .collect(Collectors.toList());

        dto.setOrderDetails(detailDTOs);
        return dto;
    }
}
