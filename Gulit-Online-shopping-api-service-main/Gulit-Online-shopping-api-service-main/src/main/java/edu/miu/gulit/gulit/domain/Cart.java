package edu.miu.gulit.gulit.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> items;

    @OneToOne
    private User user;

    public Cart(List<CartItem> items, User user) {
        this.items = items;
        this.user = user;
    }
}
