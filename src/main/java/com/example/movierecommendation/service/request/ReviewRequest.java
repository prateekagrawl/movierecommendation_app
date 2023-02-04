package com.example.movierecommendation.service.request;

import com.example.movierecommendation.domain.Movie;
import com.example.movierecommendation.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {

    private String movieReview;

    private double rating;

    private Long movieId;

    public Review toReview(){
        return Review.builder()
                .movieReview(this.movieReview)
                .rating(this.rating )
                .movie(Movie.builder().
                        movieId(movieId).build())
                .build();
    }
}
