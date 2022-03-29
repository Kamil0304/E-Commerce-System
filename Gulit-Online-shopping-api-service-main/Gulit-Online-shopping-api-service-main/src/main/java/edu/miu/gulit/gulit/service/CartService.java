package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.Cart;

public interface CartService {
    Cart findAllCart();

    Cart addToCart(long productId, int quantity);

    void deleteCartItem(int id);

    void updateCartItem(long productId, int quantity);
}
