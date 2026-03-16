package com.tai.code.entity.ticketing;

import com.tai.code.entity.catalog.Movie;
import com.tai.code.entity.catalog.Room;
import com.tai.code.entity.ticketing.enums.ShowtimeStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "showtime",

        uniqueConstraints = {
                // UNIQUE(room_id, start_time): ràng buộc 1 phòng không chiếu 2 phim cùng lúc
                @UniqueConstraint(name = "uk_showtime_room_start", columnNames = {"room_id", "start_time"})
        }
)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Showtime {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "showtime_id", updatable = false, nullable = false)
    UUID showtimeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    Room room;

    @Column(name = "start_time", nullable = false)
    LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    LocalDateTime endTime;

    @Column(name = "base_price", nullable = false, precision = 10, scale = 2)
    BigDecimal basePrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Builder.Default
    ShowtimeStatus status = ShowtimeStatus.OPENING;
}