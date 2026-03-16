package com.tai.code.entity.catalog;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import com.tai.code.entity.catalog.enums.ProductType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    Integer productId;

    @Column(name = "name", nullable = false)
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    ProductType type;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    BigDecimal price;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    Boolean isActive = true;
}
