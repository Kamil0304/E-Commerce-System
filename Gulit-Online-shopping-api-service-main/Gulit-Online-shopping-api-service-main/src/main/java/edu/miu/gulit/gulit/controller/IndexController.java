package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/")
public class IndexController {

    ProductService service;

    @Autowired
    public IndexController(ProductService service) {
        this.service = service;
    }


    @GetMapping
    public List<Product> homepage() {
       return service.findAll();

    }


}