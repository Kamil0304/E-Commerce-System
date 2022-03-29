package edu.miu.gulit.gulit.controller.domain;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.dto.ProductDto;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CartItemDto {

    private int cartItemId;
    private ProductDto product;
    private int quantity;
}
