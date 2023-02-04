package com.example.movierecommendation.domain;

import com.example.movierecommendation.service.response.MovieResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    private Double noOfReviews;

    private String adminName;

    //one movie many reviews
    @OneToMany
    List<Review> reviewList;

    public MovieResponse toMovieResponse(){
        return MovieResponse.builder().genre(this.genre).title(this.title).rating(this.rating).build();
    }

}
