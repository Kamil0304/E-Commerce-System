package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.Buyer;
import edu.miu.gulit.gulit.domain.Seller;
import edu.miu.gulit.gulit.domain.UserAddress;
import edu.miu.gulit.gulit.domain.UserOrder;
import edu.miu.gulit.gulit.repository.BuyerRepository;
import edu.miu.gulit.gulit.repository.SellerRepository;
import edu.miu.gulit.gulit.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {


    @Autowired
    UserService userService;
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    UserAddressService addressService;
   /*  @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductsService productService;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CreditCardRepository creditCardRepository;

*/

    //private String currentUserUserName ="deme";// userService.getCurrentUser().getUsername();


    @Override
    public Buyer getBuyerByUsername(String userName) {
        return buyerRepository.findBuyerByUsername(userName);
    }

    @Override
    public List<Seller> getSellersFollowed() {
        return getBuyerByUsername(userService.getCurrentUser().getUsername()).getSellersFollowed();
    }

    @Override
    public UserAddress updateBillingAddress(long address_id) {
        Buyer buyer = buyerRepository.findBuyerByUsername(userService.getCurrentUser().getUsername());
        buyer.setBillingAddress(addressService.getAddressById(address_id));
        buyerRepository.save(buyer);
        return addressService.getAddressById(address_id);
    }

    @Override
    public UserAddress updateShippingAddress(long address_id) {
        Buyer buyer = buyerRepository.findBuyerByUsername(userService.getCurrentUser().getUsername());
        buyer.setShippingAddress(addressService.getAddressById(address_id));
        buyerRepository.save(buyer);
        return addressService.getAddressById(address_id);
    }

    @Override
    public UserAddress getShippingAddress() {
        return buyerRepository.getShippingAddress(getBuyerByUsername(userService.getCurrentUser().getUsername()).getBId());
    }

    @Override
    public UserAddress getBillingAddress() {
        return buyerRepository.getBillingAddress(getBuyerByUsername(userService.getCurrentUser().getUsername()).getBId());
    }

    @Override
    public UserOrder getOrderByBuyerUserNameOrderId(long id, String userName) {
        Buyer buyer=buyerRepository.findBuyerByUsername(userName);
         return userOrderRepository.findById(buyerRepository.getOrderByBuyerUserNameOrderId( id,  buyer.getBId()));

    }

    @Override
    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer updateBuyer(Buyer buyer) {

        Buyer currentBuyer = buyerRepository.findBuyerByUsername(userService.getCurrentUser().getUsername());
        buyer.setBId(currentBuyer.getBId());
        return buyerRepository.save(buyer);

    }
    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAllBuyers();
    }

    @Override
    public Buyer getBuyerBybId(long id) {
        return buyerRepository.findBuyerByBId(id);
    }


}