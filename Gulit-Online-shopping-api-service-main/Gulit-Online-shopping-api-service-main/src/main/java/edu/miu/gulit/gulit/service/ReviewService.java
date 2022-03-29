package edu.miu.gulit.gulit.service;



        import edu.miu.gulit.gulit.domain.Product;
        import edu.miu.gulit.gulit.domain.Review;

        import java.util.List;
        import java.util.Optional;

public interface ReviewService {
    public List<Review> findAll();

    public Review findById(long id);

    public void addReview(Review review);

    public void deleteReviewById(long id);

    public List<Review> findReviewByProduct(Product product);

    public void updateReview(long id);
}
