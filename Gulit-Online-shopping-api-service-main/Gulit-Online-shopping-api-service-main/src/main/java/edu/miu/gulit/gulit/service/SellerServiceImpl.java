package edu.miu.gulit.gulit.service;

    import edu.miu.gulit.gulit.domain.Product;
        import edu.miu.gulit.gulit.domain.Seller;
    import edu.miu.gulit.gulit.domain.User;
    import edu.miu.gulit.gulit.domain.UserOrder;
    import edu.miu.gulit.gulit.repository.SellerRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

    import javax.swing.text.html.Option;
    import java.util.List;
        import java.util.Optional;
@Service
class SellerServiceImpl implements  SellerService {
    @Autowired
    SellerRepository sellerRepository;

//    @Autowired
//    SellerService sellerService;

    @Autowired
    UserOrderService orderService;

    @Override
    public Optional<Seller> loadSellerByName(String name) {
        // return SellerRepository.findById(id);
        return sellerRepository.findByUsername(name);
    }
    @Override
    public void approveSeller(long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.get().isApproved() ==false) {
            seller.get().setApproved(true);
            sellerRepository.save(seller.get());
        }
        else
            System.out.println("Seller is already approved");
    }

    @Override
    public Seller save(Seller seller) {
        if(loadSellerByName(seller.getUser().getUsername()).orElse(null)!=null) {
            System.out.println("Seller is already registered");
            return null;
        }
        return sellerRepository.save(seller);
    }
    @Override
    public Seller update(Seller seller, long id) {
        seller.setSellerId(id);
        return sellerRepository.save(seller);
    }
    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }
    @Override
    public Optional<Seller> findById(long id) {

        return sellerRepository.findById(id);
    }
    @Override
    public void deleteById(long id) {
        if(findById(id)!=null)
        {
            sellerRepository.deleteById(id);
        }
        else
        {
            System.out.println("seller doesn't exist");
        }
    }

    @Override
    public List<Product> findProductsBySellerId(long id) {
        List<Product>  result =null;
       Optional<Seller> sellingPersong = findById(id);
                for(Product p : sellingPersong.get().getProducts())
                result.add(p) ;
        return result;
    }

    @Override
    public UserOrder cancelSellerOrder(String userName, long oId) {
//        Seller seller =sellerService.loadSellerByName(userName).get();
//        List<Long> lOID= sellerService.getOrderIdsBySellerBySId(seller.getSellerId());
//        if( lOID.contains(oId)) {
//            UserOrder order=orderService.getOrderById(oId);
//            if (order.getOrderStatus()!=OrderStatus.Shipped.getOrderStatus())
//                order.setOrderStatus(OrderStatus.Cancelled.getOrderStatus());
//            orderService.save(order);
//            return order;
//        }
       return null;
         }

    @Override
    public UserOrder shipSellerOrder(String userName, long oId) {
//        Seller seller =sellerRepository.findByUsername(userName).get();
//        List<Long> lOID= this.getOrderIdsBySellerBySId(seller.getSId());
//        if( lOID.contains(oId)) {
//            Order order=orderService.getOrderById(oId);
//            order.setOrderStatus(OrderStatus.Shipped.getOrderStatus());
//            orderService.save(order);
//            sellerService.save(seller);
//            return order;
//        }
        return null;
    }

}