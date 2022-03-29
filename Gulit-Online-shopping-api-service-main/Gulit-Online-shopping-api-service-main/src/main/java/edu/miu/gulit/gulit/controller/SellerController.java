package edu.miu.gulit.gulit.controller;


 import edu.miu.gulit.gulit.domain.Seller;
 import edu.miu.gulit.gulit.domain.UserOrder;
 import edu.miu.gulit.gulit.service.SellerService;
 import edu.miu.gulit.gulit.service.UserService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import javax.validation.Valid;
 import java.util.List;
 import java.util.Optional;


@CrossOrigin()
@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;
    @Autowired
    UserService Userservice;
    @GetMapping("{id}")
    public Optional<Seller> findById(@PathVariable("id") long id) {
        return sellerService.findById(id);
    }
    @GetMapping("{name}")
    public Optional<Seller> loadSellerByName(@PathVariable  String name) {
        {
            return sellerService.loadSellerByName(name);
        }
    }
    @GetMapping
    public List<Seller> findAll() {
        return sellerService.findAll();
    }

    @PostMapping
    public Seller save(@RequestBody @Valid Seller data) {
        return sellerService.save(data);
    }
    //
    @PutMapping("{id}")
    public Seller update(@RequestBody  Seller user, @PathVariable long id) {
        return sellerService.update(user, id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable  long id) {
        sellerService.deleteById(id);
    }

    @PutMapping("/approve/{id}")
    public  void approveSeller(@PathVariable long id)
    {
        sellerService.approveSeller(id);
    }

    @PostMapping("/{userName}/order/cancel/{id}")
    public UserOrder cancelSellerOrder(@PathVariable("userName") String userName,@PathVariable("id") long oId){
        return sellerService.cancelSellerOrder(userName,oId);
    }
    @PostMapping("/{userName}/order/shipped/{id}")
    public UserOrder shipSellerOrder(@PathVariable("userName") String userName, @PathVariable("id") long oId){
        return sellerService.shipSellerOrder(userName,oId);
    }
}


