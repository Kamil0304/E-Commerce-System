package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import edu.miu.gulit.gulit.domain.CartItem;
 import edu.miu.gulit.gulit.domain.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SellerRepository extends CrudRepository<Seller, Long> {

    @Override
    public List<Seller> findAll();


    public Optional<Seller> findById(long id);

     @Query("select  s from Seller s where  s.user.username = :username" )
    public Optional<Seller> findByUsername(@Param(  "username" ) String username);
    @Override
    public Seller save(Seller user);


    public  void deleteById(long id);
}
