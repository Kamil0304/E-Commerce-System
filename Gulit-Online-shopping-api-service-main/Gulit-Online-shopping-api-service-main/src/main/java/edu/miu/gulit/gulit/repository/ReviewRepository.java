package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
        import java.util.Optional;
@Repository
public interface ReviewRepository extends CrudRepository <Review,Long> {
    public List<Review> findAll();
    public Review findById(long id);

    @Query("select p.revews from Product p where p.id = :id")
    public List<Review> findReviewByProduct(@Param("id") long id);
}