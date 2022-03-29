package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.Cart;
import edu.miu.gulit.gulit.domain.CartItem;
import edu.miu.gulit.gulit.domain.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    Optional<Cart> findTopByUser(User user);
}
