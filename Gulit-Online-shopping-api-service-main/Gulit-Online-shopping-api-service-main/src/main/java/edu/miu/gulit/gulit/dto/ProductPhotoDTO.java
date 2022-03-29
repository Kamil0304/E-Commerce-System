package edu.miu.gulit.gulit.dto;

import edu.miu.gulit.gulit.domain.Product;
import org.hibernate.validator.constraints.URL;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ProductPhotoDTO extends RepresentationModel<ProductPhotoDTO> implements Serializable {


    private long id;

    //@NotBlank
    @URL
    private String url;

    @ManyToOne
    private Product product;

}
