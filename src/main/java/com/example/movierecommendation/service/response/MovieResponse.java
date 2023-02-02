package com.example.movierecommendation.service.response;

import com.example.movierecommendation.domain.Genre;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {

    private String title;

    private Genre genre;

    private double rating;
}
