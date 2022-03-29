package edu.miu.gulit.gulit.controller;
import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.Review;
import edu.miu.gulit.gulit.repository.ReviewRepository;
import edu.miu.gulit.gulit.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/products/{id}/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping()
    public List<Review> findAll() {
        return reviewService.findAll();
    }
    @GetMapping("/{reviewId}")
    public Review findById(@PathVariable("reviewId") long id) {
        return reviewService.findById(id);
    }
    @PostMapping("/add")
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
    }
    @PostMapping("/{reviewId}/delete")
    public void deleteReviewById(@PathVariable("reviewId") long id) {
        reviewService.deleteReviewById(id);
    }
    @GetMapping({"/idd"})
    public List<Review> findReviewByProduct(@RequestBody Product product) {
        return reviewService.findReviewByProduct(product);
    }
    @PutMapping("/{pid}")
    public void updateReview(@PathVariable("pid")long id) {
        reviewService.updateReview(id);
    }
}
