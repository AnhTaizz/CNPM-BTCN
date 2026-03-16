package com.tai.code.entity.catalog;

import com.tai.code.entity.catalog.enums.RoomType;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)

@Entity
@Table(name="room",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_room_cinema_name", columnNames = {"cinema_id", "name"})
        })
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id",nullable = false)
    Integer roomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cinema_id", nullable = false)
    Cinema cinema;

    @Column(nullable = false)
    String name;

    @Column(name="total_rows")
    Integer totalRows;

    @Column(name="total_cols")
    Integer totalCols;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    RoomType type;
}
