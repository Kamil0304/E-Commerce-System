package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
}
