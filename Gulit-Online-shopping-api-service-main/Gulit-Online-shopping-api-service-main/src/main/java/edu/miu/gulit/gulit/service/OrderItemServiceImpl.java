package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.OrderItem;
import edu.miu.gulit.gulit.repository.OrderItemRepository;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService{

    OrderItemRepository orderItemRepository;
    @Override
    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findById(long id) {
        return orderItemRepository.findById(id);
    }
}
