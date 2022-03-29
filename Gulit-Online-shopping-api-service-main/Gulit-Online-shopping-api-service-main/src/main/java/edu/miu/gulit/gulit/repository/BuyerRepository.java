package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.Buyer;
import edu.miu.gulit.gulit.domain.Seller;
import edu.miu.gulit.gulit.domain.UserAddress;
import edu.miu.gulit.gulit.domain.UserOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuyerRepository extends CrudRepository<Buyer,Long> {

    @Query("select b from Buyer b where b.user.username = :userName")
    public Buyer findBuyerByUsername(@Param("userName") String userName);

    @Query("select b from Buyer b where b.bId = :bId")
    public Buyer findBuyerByBId(@Param("bId") long id);

    @Query("select b from Buyer b")
    public List<Buyer> findAllBuyers();


    @Query("select b.orders from Buyer b where b.bId = :id ")
    public List<UserOrder> getAllOrdersByBuyerId(@Param("id") long id);

    @Query("select b.shippingAddress from Buyer b where b.bId=:id")
    public UserAddress getShippingAddress(@Param("id") long id);

    @Query("select b.billingAddress from Buyer b where b.bId=:id")
    public UserAddress getBillingAddress(@Param("id") long id);


    @Query("select b.sellersFollowed from Buyer b where b.bId = :id ")
    public List<Seller> getSellerFollowedByBuyerId(@Param("id") long id);


    @Query("select b.points from Buyer b where b.bId = :id ")
    public long getBuyerPoints(@Param("id") long id);

    @Query("select b from Buyer b where b.user.email = :email ")
    public Buyer findBuyerByEmail(@Param("email") String email);
    @Query(value = "select o.id from ord o inner join buyer_orders bo  on o.id=bo.orders_id where bo.buyer_b_id=:bId and o.id=:id",nativeQuery = true)
    public long getOrderByBuyerUserNameOrderId(long id, long bId);

}