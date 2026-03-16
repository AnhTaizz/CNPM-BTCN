package com.tai.code.entity.catalog;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="genre")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="genre_id")
    Integer genreId;

    @Column(name="name", length = 100)
    String name;
}
