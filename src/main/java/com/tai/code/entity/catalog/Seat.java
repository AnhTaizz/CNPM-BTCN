package com.tai.code.entity.catalog;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="seat",
    uniqueConstraints = {
        @UniqueConstraint(name="uk_seat_row_number", columnNames = {"room_id", "row_label", "seat_number"}),
        @UniqueConstraint(name="uk_seat_room_grid", columnNames = {"room_id", "grid_row", "grid_col"})
    })
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seat_id")
    Integer seatId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id", nullable = false)
    Room room;
    
    @Column(name="row_label", length = 10)
    String rowLabel;
    
    @Column(name="seat_number")
    Integer seatNumber;
    
    @Column(name="grid_row")
    Integer gridRow;
    
    @Column(name="grid_col")
    Integer gridCol;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seat_type_id", nullable = false)
    SeatType seatType;
    
    @Column(nullable = false)
    @Builder.Default
    Boolean isActive = true;
    
}
