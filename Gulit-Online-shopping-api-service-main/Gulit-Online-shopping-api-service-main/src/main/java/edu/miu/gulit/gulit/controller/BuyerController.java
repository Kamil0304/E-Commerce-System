package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.*;
import edu.miu.gulit.gulit.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
    @RestController
    @RequestMapping("/buyers")
    public class BuyerController {

        @Autowired
        BuyerService buyerService;
     /*   @Autowired
        SellerService sellerService;
        @Autowired
        UserOrderService orderService;*/

        @PostMapping
        public Buyer saveBuyer(@RequestBody Buyer buyer){

            return buyerService.saveBuyer(buyer);
        }
        @PutMapping("/profile/")
        public Buyer updateBuyer(@RequestBody Buyer buyer){
            return buyerService.updateBuyer(buyer);
        }
        @GetMapping
        public List<Buyer> getAllBuyers(){
            return buyerService.getAllBuyers();
        }

        @GetMapping("/{id}")
        public Buyer getBuyerById(@PathVariable("id") long id){
            return buyerService.getBuyerBybId(id);
        }

        @GetMapping("/follows")
        public List<Seller> getSellerFollowersByBuyer(){
            return buyerService.getSellersFollowed();
        }

    @PutMapping("/profile/billing/{address_id}")
    public UserAddress updateBillingAddress(@PathVariable long address_id){
        return buyerService.updateBillingAddress(address_id);
    }
    @PutMapping("/profile/shipping/{address_id}")
    public UserAddress updateShippingAddress(@PathVariable long address_id){
        return buyerService.updateShippingAddress(address_id);
    }
    @GetMapping("/shippingAddress")
    public UserAddress getShippingAddress() {
        return buyerService.getShippingAddress();
    }

    @GetMapping("/{userName}/order/{id}")
    public UserOrder getOrderByBuyerUserNameOrderId(@PathVariable long id, @PathVariable String userName){

        return buyerService.getOrderByBuyerUserNameOrderId(id, userName);
    }

    @GetMapping("/BillingAddress")
    public UserAddress getBillingAddress() {
        return buyerService.getBillingAddress();
    }
   /*     @PostMapping("/{buyerUserName}/follow/{sellerUserName}")
        public void followSeller(@PathVariable String sellerUserName){
            buyerService.followSeller(sellerService.getSellerByUserName(sellerUserName).getSId()
            );
        }
        @PostMapping("/{bUserName}/unfollow/{sUserName}")
        public void unFollowSeller(@PathVariable String bUserName, @PathVariable String sUserName){
            buyerService.unFollowSeller(
                    buyerService.getBuyerByUsername(bUserName).getBId(),
                    sellerService.getSellerByUserName(sUserName).getSId()
            );
        }

        @GetMapping("/{userName}/order/{id}")
        public Order getOrderByBuyerUserNameOrderId(@PathVariable long id, @PathVariable String userName){

            return buyerService.getOrderByBuyerUserNameOrderId(id, userName);
        }



        @GetMapping("/{userName}/order/{id}/listItems")
        public List<LineItem> listOrderItems(@PathVariable("userName") String userName, @PathVariable("id") long id){
            return buyerService.listOrderItems(userName,id);
        }

        @PostMapping("/profile/{seller_UserName}/billing")
        public Address addBillingAddress(@PathVariable String seller_UserName,@RequestBody Address address){
            return buyerService.addBillingAddress(seller_UserName,address);
        }


*/

    }