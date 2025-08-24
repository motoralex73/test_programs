package com.motoralex.reservationservice.repo;

import java.time.LocalDateTime;

public record Reservation(Long id,
                          Long userId,
                          Long roomId,
                          LocalDateTime startDate,
                          LocalDateTime endDate,
                          ReservationStatus reservationStatus) {
}
