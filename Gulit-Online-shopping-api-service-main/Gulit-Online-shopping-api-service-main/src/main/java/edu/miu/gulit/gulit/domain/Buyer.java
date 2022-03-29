package edu.miu.gulit.gulit.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long bId;

    @Digits(integer = 6, fraction = 0)
    long points=0;

    @OneToMany(mappedBy = "buyer")
    @Fetch(FetchMode.SELECT)
    private List<UserOrder> orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="User_ID")
    private User user;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private UserAddress shippingAddress=new UserAddress();

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private UserAddress billingAddress=new UserAddress();

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sellerSubsciptions")
    private List<Seller> sellersFollowed=new ArrayList<>();

}