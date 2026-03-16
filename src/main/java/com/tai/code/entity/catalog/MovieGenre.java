package com.tai.code.entity.catalog;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="movie_genre")
@IdClass(MovieGenre.MovieGenreId.class)
public class MovieGenre {
    @Id
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name="movie_id", nullable = false)
    UUID movieId;

    @Id
    @Column(name = "genre_id", nullable = false)
    Integer genreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_id", insertable = false, updatable = false)
    Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="genre_id", insertable = false, updatable = false)
    Genre genre;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode // Bắt buộc phải có để so sánh 2 object khóa
    public static class MovieGenreId implements Serializable {
        private UUID movieId;
        private Integer genreId;
    }
}
