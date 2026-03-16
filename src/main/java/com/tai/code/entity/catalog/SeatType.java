package com.tai.code.entity.catalog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="seattype")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seat_type_id")
    Integer seatTypeId;

    @Column(name="name", length = 50)
    String name;

    @Column(name="price_multiplier", precision = 5, scale = 2)
    BigDecimal priceMultiplier;

    @Column(name="description", columnDefinition = "TEXT")
    String description;
}
