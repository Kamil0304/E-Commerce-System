package edu.miu.gulit.gulit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seller")
public class Seller{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long sellerId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    User user;
    boolean isApproved;
    //@Size(min = 3)
    //@NotEmpty

    String company;
    //@Size(min = 5)
    //@NotEmpty
    String website;
    @OneToMany(mappedBy = "seller" ,cascade = CascadeType.ALL)
    @JsonIgnore
    List<Product> products;


}