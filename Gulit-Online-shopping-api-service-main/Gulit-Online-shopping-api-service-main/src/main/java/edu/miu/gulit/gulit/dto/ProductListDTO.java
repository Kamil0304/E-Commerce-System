package edu.miu.gulit.gulit.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductListDTO extends RepresentationModel<ProductDto>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<ProductDto> products = new ArrayList<>();

}