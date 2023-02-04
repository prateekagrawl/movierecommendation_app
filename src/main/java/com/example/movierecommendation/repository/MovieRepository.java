package com.example.movierecommendation.repository;

import com.example.movierecommendation.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie findByTitle(String title);
/*
    @Query("select m from Movie m where m.title = :title")
    Movie findByName(String title); */

    @Query("select m from Movie m where m.title = ?1 ")
    Movie findByName(String title);

    @Query(value = "select * from movie_table m where m.title= ? and m.rating=?",nativeQuery = true)
    Movie findByNameAndRating(String name,Double rating);
}
