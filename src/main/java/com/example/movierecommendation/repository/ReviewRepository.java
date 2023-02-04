package com.example.movierecommendation.repository;

import com.example.movierecommendation.domain.Movie;
import com.example.movierecommendation.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Query("select count(r) from Review r where r.movie = ?1")
    Review countTotalReviews(Long movieId);
}
