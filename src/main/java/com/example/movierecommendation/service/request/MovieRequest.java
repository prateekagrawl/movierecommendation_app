package com.example.movierecommendation.service.request;

import com.example.movierecommendation.domain.Genre;
import com.example.movierecommendation.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

    private String title;

    private Genre genre;

    public Movie toMovie(){
        return Movie.builder().title(this.title).genre(this.genre).rating(0.0).adminName("localhostAdmin").build();
    }
}
