package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.User;
import edu.miu.gulit.gulit.domain.UserOrder;
import edu.miu.gulit.gulit.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserOrderService {

    UserOrder findById(long id);

    UserOrder loadOrderbyName(String username);

    List<UserOrder> findAll();

    UserOrder save(UserOrder data);

    UserOrder update(UserOrder user, long id);

    void deleteById(long id);

    UserOrder deliveredOrder(String userName, long id);
}
