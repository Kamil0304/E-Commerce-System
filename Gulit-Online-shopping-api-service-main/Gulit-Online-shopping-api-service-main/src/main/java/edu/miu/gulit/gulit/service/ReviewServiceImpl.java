package edu.miu.gulit.gulit.service;
import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.Review;
import edu.miu.gulit.gulit.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteReviewById(long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> findReviewByProduct(Product product) {
        var id = product.getId();
        return reviewRepository.findReviewByProduct(id);
    }

    @Override
    public void updateReview(long id) {
        Review review = reviewRepository.findById(id);
        reviewRepository.save(review);
    }
}
