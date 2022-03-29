package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.controller.domain.CartItemDto;
import edu.miu.gulit.gulit.controller.domain.CartItemRequest;
import edu.miu.gulit.gulit.domain.CartItem;
import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.ProductPhoto;
import edu.miu.gulit.gulit.dto.ProductDto;
import edu.miu.gulit.gulit.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin()
@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartItemDto> getAllCartItems() {
        return Optional.ofNullable(cartService.findAllCart().getItems()).orElse(List.of()).stream()
                .map(this::buildCartItemDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void saveCartItem(@RequestBody CartItemRequest cartItem) {
        cartService.addToCart(cartItem.getProductId(), cartItem.getQuantity());
    }

    @PutMapping("/cart-items/")
    public void updateCartItem(@RequestBody CartItemRequest cartItem) {
        cartService.updateCartItem(cartItem.getProductId(), cartItem.getQuantity());
    }

    @DeleteMapping("/cart-items/{cartItemId}")
    public void deleteCartItem(@PathVariable("cartItemId") int id) {
        cartService.deleteCartItem(id);
    }

    private CartItemDto buildCartItemDto(CartItem cartItem) {

        Product product = cartItem.getProduct();
        List<String> imageUrls = Optional.ofNullable(product.getImages()).orElse(List.of()).stream()
                .map(ProductPhoto::getUrl)
                .collect(Collectors.toList());

        ProductDto productDto = new ProductDto(product.getId(), product.getName(), product.getDescription(),
                product.getIsActive(), product.getQuantity(), product.getPrice(), product.getCategory(), product.getName(), imageUrls);

        return new CartItemDto(cartItem.getId(), productDto, cartItem.getQuantity());
    }
}
