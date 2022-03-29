package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.ProductPhoto;
import edu.miu.gulit.gulit.dto.ProductPhotoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {

    @Override
    public Product save(Product entity) ;

    @Override
    public Optional<Product> findById(Long aLong);

    @Override
    public boolean existsById(Long aLong);

    @Override
    public List<Product> findAll() ;

    @Override
    public void deleteById(Long aLong);

    @Query("select p.images from Product p where p.id = :id")
    List<ProductPhoto> getImagesById(@Param("id") long id);


}
