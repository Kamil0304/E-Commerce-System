package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.ProductPhoto;
import edu.miu.gulit.gulit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/products")
public class ProductController{

    ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Product findById(@PathVariable("id") long id) {
        return service.findById(id);
    }


    @PostMapping
    public Product save(@RequestBody  Product data) {
        return service.save(data);
    }


    @PutMapping("{id}")
    public Product update(@RequestBody  Product data, @PathVariable long id) {
       return service.update(data, id);
    }


    @DeleteMapping("{id}")
    public void deleteById(@PathVariable  long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}/images")
    public List<ProductPhoto> findImagesById(@PathVariable long id) {
       return  service.findImagesById(id);
    }
}
