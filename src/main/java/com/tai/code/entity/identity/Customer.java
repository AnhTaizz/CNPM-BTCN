package com.tai.code.entity.identity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import com.tai.code.entity.identity.enums.Member;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@PrimaryKeyJoinColumn(name="user_id")

@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="customer")
public class Customer extends User{
    @Column(name="registration_date")
    LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name="member_level")
    Member memberLevel;

    @Column(name="loyalty_points")
    @Builder.Default
    Integer loyaltyPoints = 0;
}
