package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.OrderItem;
import edu.miu.gulit.gulit.domain.User;
import edu.miu.gulit.gulit.domain.UserOrder;
import edu.miu.gulit.gulit.service.UserOrderService;
import edu.miu.gulit.gulit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/orders")
public class UserOrderController {
    @Autowired
    UserOrderService userOrderService;
    @GetMapping("{id}")
    public UserOrder findById(@PathVariable("id") long id) {
      return userOrderService.findById(id);
    }
    @GetMapping("{ordername}")
    public UserOrder findByUsername(@PathVariable  String username) {
        {
            return userOrderService.loadOrderbyName(username);
        }
    }
    @GetMapping
    public List<UserOrder> findAll() {
        return userOrderService.findAll();
    }

    @PostMapping
    public UserOrder save(@RequestBody UserOrder data) {
        return userOrderService.save(data);
    }
    //
    @PutMapping("{id}")
    public UserOrder update(@RequestBody  UserOrder order, @PathVariable long id) {
        return userOrderService.update(order, id);
    }
    //
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable  long id) {
        userOrderService.deleteById(id);
    }

    @PostMapping("/{userName}/orders/delivered/{id}")
    public UserOrder deliveredOrder(@PathVariable("userName") String userName,@PathVariable("id") long Id){
        return userOrderService.deliveredOrder(userName,Id);
    }


////    @PostMapping("/{userName}/order/returned/{id}")
////    public UserOrder returnedOrder(@PathVariable("userName") String userName,@PathVariable("id") long oId){
////        return  buyerService.returnedOrder(userName,oId);
////    }
//

//    @PostMapping("/{userName}/order")
//    public void addOrder(@RequestBody UserOrder order, @PathVariable String userName){
//
//        buyerService.addOrder(order,userName);
//

//    }
//    @DeleteMapping("/{userName}/order/{id}")
//    public boolean deleteOrder(@PathVariable("userName") String userName, @PathVariable("id") long id){
//        return buyerService.deleteOrder(userName,id);
//    }

}
