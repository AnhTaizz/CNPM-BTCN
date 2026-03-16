package com.tai.code.entity.ticketing;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.tai.code.entity.catalog.Seat;
import com.tai.code.entity.ticketing.enums.TicketStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ticket", indexes = {
        @Index(name = "idx_ticket_showtime", columnList = "showtime_id"),
        @Index(name = "idx_ticket_seat", columnList = "seat_id")
})
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Ticket {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @UuidGenerator
    @JdbcTypeCode((SqlTypes.UUID))
    @Column(name="ticket_id", updatable = false, nullable = false)
    UUID ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", insertable = false, updatable = false)
    Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_id", insertable = false, updatable = false)
    Showtime showtime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", insertable = false, updatable = false)
    Seat seat;

    @Column(name = "ticket_code", nullable = false, unique = true)
    String ticketCode;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    BigDecimal price;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Builder.Default
    TicketStatus status = TicketStatus.PAID;

    @Column(name = "check_in_time")
    LocalDateTime checkInTime;
}
