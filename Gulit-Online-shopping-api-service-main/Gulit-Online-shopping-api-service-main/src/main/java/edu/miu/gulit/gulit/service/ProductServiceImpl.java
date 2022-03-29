package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.*;
import edu.miu.gulit.gulit.repository.ProductRepository;
import edu.miu.gulit.gulit.repository.UserOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository repository;

    @Autowired
    ModelMapper mapper;
    @Autowired
    UserOrderRepository orderRepository;
    @Autowired
    UserService userService;

    @Autowired
    SellerService sellerService;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {

        if(repository.existsById(product.getId())) {
            System.out.println("Product already registered");
            return null;
        }
       product.setSeller(sellerService.loadSellerByName(userService.getCurrentUser().getUsername()).get());
       System.out.println(userService.getCurrentUser().getUsername());
       return repository.save(product);
    }
    @Override
    public Product update(Product product, long id) {
        product.setId(id);
        return repository.save(product);
    }
    @Override
    public List<Product> findAll() {
        if (repository.findAll()==null) return  null;
       return repository.findAll();
    }
    @Override
    public Product findById(long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public void deleteById(long id) {
    List<OrderItem> orderItems = findById(id).getOrderItems();
            if(orderItems.size() < findById(id).getQuantity())repository.deleteById(id);
            else   System.out.println("Product is Ordered by a buyer , can't be deleted");
    }
    @Override
    public List<ProductPhoto> findImagesById(long id) {
        if(repository.getImagesById(id)==null) return null;
        return repository.getImagesById(id);
    }
}
