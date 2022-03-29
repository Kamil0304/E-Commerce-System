package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.Cart;
import edu.miu.gulit.gulit.domain.CartItem;
import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.User;
import edu.miu.gulit.gulit.repository.CartItemRepository;
import edu.miu.gulit.gulit.repository.CartRepository;
import edu.miu.gulit.gulit.repository.ProductRepository;
import edu.miu.gulit.gulit.repository.UserRepository;
import edu.miu.gulit.gulit.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
            private ProductRepository productRepository;

    Cart cart = new Cart();

    @Override
    public Cart findAllCart() {
        User user = getCurrentUser();
        return findOrCreateCart(user);
    }

    private User getCurrentUser(){
        return UserUtil.getCurrentUserLogin()
                .flatMap(username -> userRepository.findByUsername(username))
                .orElse(null);
    }

    private Cart findOrCreateCart(User user) {

        return cartRepository.findTopByUser(user)
                        .orElseGet(() -> {
                            Cart cart = new Cart(null, user);
                            return cartRepository.save(cart);
                        });
    }


    public Cart addToCart(long productId, int quantity) {

        User user = getCurrentUser();
        Cart cart = findOrCreateCart(user);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Invalid product id"));

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        cartItemRepository.save(cartItem);
        return findOrCreateCart(user);
    }

    @Override
    public void deleteCartItem(int id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public void updateCartItem(long productId, int quantity) {

        Cart cart = findOrCreateCart(getCurrentUser());

        List<CartItem> cartItems = Optional.ofNullable(cart.getItems()).orElse(List.of());

        Optional.ofNullable(cart.getItems()).orElse(List.of()).stream()
                .filter(item -> item.getProduct().getId() == productId)
                .findFirst()
                .map(cartItem -> {
                    cartItem.setQuantity(quantity);
                    return cartItemRepository.save(cartItem);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid product id"));
    }
}
