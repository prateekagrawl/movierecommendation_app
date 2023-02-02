package com.example.movierecommendation.domain;

import com.example.movierecommendation.service.response.MovieResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "movie_table")
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;       //mysql -> bigint, columnName -> movie_id

    private String title;   //mysql -> varchar

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Double rating;

    private String adminName;

    public MovieResponse toMovieResponse(){
        return MovieResponse.builder().genre(this.genre).title(this.title).rating(this.rating).build();
    }

}
