package com.example.movierecommendation.controller;

import com.example.movierecommendation.domain.Review;
import com.example.movierecommendation.service.ReviewService;
import com.example.movierecommendation.service.request.ReviewRequest;
import com.example.movierecommendation.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/add/review")
    public void addReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.addReview(reviewRequest.toReview());
    }

    @GetMapping("/find/review")
    public Review getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }

//    @GetMapping("/find/totalReviewsCount")
//    public Review getAverageRating(@RequestParam ReviewRequest reviewRequest){
//        return reviewService.getAverageRating(reviewRequest.toReview());
//    }

}
