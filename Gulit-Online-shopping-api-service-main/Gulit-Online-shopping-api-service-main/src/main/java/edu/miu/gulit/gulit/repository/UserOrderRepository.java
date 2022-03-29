package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.OrderStatus;
import edu.miu.gulit.gulit.domain.UserOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserOrderRepository extends CrudRepository<UserOrder,Long> {

    UserOrder findById(long id);

   // UserOrder loadOrderbyName(String username);
     @Override
    List<UserOrder> findAll();

    UserOrder save(UserOrder data);

   // UserOrder update(UserOrder user, long id);


    void deleteById(long id);

}
