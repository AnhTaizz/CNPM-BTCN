package com.tai.code.entity.catalog;

import com.tai.code.entity.catalog.enums.CinemaStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    Integer cinemaId;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "hotline", length = 20)
    String hotline;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    CinemaStatus status = CinemaStatus.OPEN;
}
