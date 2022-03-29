package edu.miu.gulit.gulit.service;

        import edu.miu.gulit.gulit.domain.Product;
        import edu.miu.gulit.gulit.domain.Seller;
        import edu.miu.gulit.gulit.domain.User;
        import edu.miu.gulit.gulit.domain.UserOrder;

        import java.util.List;
        import java.util.Optional;


public interface SellerService {

    Optional<Seller> loadSellerByName(String name);
    public void approveSeller(long id);
    Seller save(Seller  seller);
    Seller update(Seller seller, long id);
    List<Seller> findAll();
    Optional<Seller> findById(long id);
    void deleteById(long id);
    List<Product> findProductsBySellerId(long id);


    UserOrder cancelSellerOrder(String userName, long oId);

    UserOrder shipSellerOrder(String userName, long oId);
}