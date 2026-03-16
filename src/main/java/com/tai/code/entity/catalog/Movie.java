package com.tai.code.entity.catalog;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import com.tai.code.entity.catalog.enums.AgeRating;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="movie")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name="movie_id")
    UUID movieId;

    @Column(name="title", nullable = false)
    String title;

    @Column(name="director")
    String director;

    @Column(name="duration", nullable=false)
    Integer durationMinutes;

    @Column(name="poster_url")
    String posterUrl;

    @Column(name="description", columnDefinition = "text")
    String description;

    @Column(name="release")
    LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name="age_rating")
    AgeRating ageRating;
}
