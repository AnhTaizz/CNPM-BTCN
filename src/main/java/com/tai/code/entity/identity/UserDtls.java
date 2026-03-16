package com.tai.code.entity.identity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="userdtls")
@Inheritance(strategy = InheritanceType.JOINED)

public class UserDtls {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name="user_id")
    UUID userId;

    @Column(name="full_name", nullable = false)
    String fullName;

    @Column(nullable = false)
    String passwordHash;

    @Column(name="phone_number", nullable = false, unique=true, length = 20)
    String phoneNumber;

    @Column(name="email", unique = true)
    String email;

    @Column(name="birth_date")
    LocalDate birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", nullable = false)
    Role role;

    @Column(name="is_active")
    @Builder.Default
    Boolean isActive = true;

    @CreatedDate
    @Column(name="created_at", nullable=false, updatable = false)
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    LocalDateTime updateAt;
}
