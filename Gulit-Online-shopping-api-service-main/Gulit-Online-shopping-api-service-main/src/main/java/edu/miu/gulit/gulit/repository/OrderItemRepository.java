package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem,Long> {

    public List<OrderItem> findAll();
    public  OrderItem findById(long id);

}
