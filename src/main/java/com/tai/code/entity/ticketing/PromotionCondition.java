package com.tai.code.entity.ticketing;

import com.tai.code.entity.catalog.Promotion;
import com.tai.code.entity.ticketing.enums.PromotionConditionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "promotion_condition")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromotionCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condition_id")
    Long conditionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id", insertable = false, updatable = false)
    Promotion promotion;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition_type")
    PromotionConditionType conditionType;

    @Column(name = "condition_value")
    String conditionValue;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    LocalDateTime createdAt;
}
