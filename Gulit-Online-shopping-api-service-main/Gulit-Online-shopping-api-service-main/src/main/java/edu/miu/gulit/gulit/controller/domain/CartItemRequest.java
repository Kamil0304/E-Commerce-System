package edu.miu.gulit.gulit.controller.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class CartItemRequest {

    private int productId;
    private int quantity;
}
