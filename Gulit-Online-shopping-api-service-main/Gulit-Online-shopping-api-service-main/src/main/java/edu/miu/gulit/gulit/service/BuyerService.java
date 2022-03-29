package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.Buyer;
import edu.miu.gulit.gulit.domain.Seller;
import edu.miu.gulit.gulit.domain.UserAddress;
import edu.miu.gulit.gulit.domain.UserOrder;

import java.util.List;

public interface  BuyerService {
    Buyer saveBuyer(Buyer buyer);

    Buyer updateBuyer(Buyer buyer);

    List<Buyer> getAllBuyers();

    Buyer getBuyerBybId(long id);

    Buyer getBuyerByUsername(String userName);

    List<Seller> getSellersFollowed();

    UserAddress updateBillingAddress(long address_id);

    UserAddress updateShippingAddress(long address_id);
    
    UserAddress getShippingAddress();

    UserAddress getBillingAddress();
    public UserOrder getOrderByBuyerUserNameOrderId(long id, String userName);

}
