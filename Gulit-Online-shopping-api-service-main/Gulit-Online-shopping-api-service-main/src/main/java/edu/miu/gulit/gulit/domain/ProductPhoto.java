package edu.miu.gulit.gulit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.gulit.gulit.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
//import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhoto {

    @Id
    @GeneratedValue
    private long id;

    //@NotBlank
    @URL
    private String url;
    @JsonIgnore
    @ManyToOne
    private Product product;
}
