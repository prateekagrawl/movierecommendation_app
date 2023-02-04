package com.example.movierecommendation.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review_table")
public class Review {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;       //mysql -> int

    private String movieReview;   //mysql -> varchar

    private double rating;

    //many reviews one movie
    @ManyToOne //make relationship with Movie entity
    @JoinColumn //then join column
    private Movie movie;  //movie_movie_id

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

}
