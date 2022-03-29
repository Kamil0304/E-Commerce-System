package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.Cart;
import edu.miu.gulit.gulit.domain.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> findAllOrderItems();

    OrderItem findById(long id);

}
