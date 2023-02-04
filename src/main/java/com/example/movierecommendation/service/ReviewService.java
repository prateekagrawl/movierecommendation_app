package com.example.movierecommendation.service;

import com.example.movierecommendation.domain.Review;
import com.example.movierecommendation.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public void addReview(Review review){
        reviewRepository.save(review);
    }


    public Review getReviewById(Long reviewId) {
        /*
        Optional<Review> optionalReview=reviewRepository.findById(reviewId);
        if(optionalReview.isPresent())
            return optionalReview.get();
        else {
            // throw exception
            return null; // or return blank new Review();
        }
        */
        Review review = reviewRepository.findById(reviewId).orElse(null);
        return review;
    }

//    public Review getAverageRating(Review review) {
//        System.out.println(review);
//        Review review1 = reviewRepository.countTotalReviews(review);
//        return review1;
//    }
}
