package com.tai.code.entity.catalog;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.tai.code.entity.catalog.enums.DiscountType;
import com.tai.code.entity.catalog.enums.PromotionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "promotion")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Promotion {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "promotion_id", updatable = false, nullable = false)
    UUID promotionId;

    @Column(name = "code", unique = true, length = 50)
    String code;

    @Column(name = "name")
    String name;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type")
    DiscountType discountType;

    @Column(name = "discount_value", precision = 10, scale = 2)
    BigDecimal discountValue;

    @Column(name = "max_discount", precision = 10, scale = 2)
    BigDecimal maxDiscount;

    @Column(name = "start_time")
    LocalDateTime startTime;

    @Column(name = "end_time")
    LocalDateTime endTime;

    @Column(name = "usage_limit")
    Integer usageLimit;

    @Column(name = "usage_count")
    @Builder.Default
    Integer usageCount = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    PromotionStatus status;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    LocalDateTime createdAt;
}
