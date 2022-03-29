package edu.miu.gulit.gulit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
//import javax.validation.constraints.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Size(min = 3)
    //@NotEmpty
    private String name;

    //@Size(min = 5)
    //@NotEmpty
    private String description;

    private Boolean isActive;

    //@Min(1)
    private int quantity;
    //@Min(0)
    private  double price;

    @OneToMany(mappedBy = "product")
    List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "category_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_ID")
    private  Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductPhoto> images;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<CartItem> cartItems;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private  List<Review> revews;

    @JsonIgnore
    @ManyToOne
    private Seller seller;
}
