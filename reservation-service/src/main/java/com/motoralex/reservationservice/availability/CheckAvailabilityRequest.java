package com.motoralex.reservationservice.availability;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CheckAvailabilityRequest(
        @NotNull
        Long roomId,
        @NotNull
        LocalDateTime startDate,
        @NotNull
        LocalDateTime endDate
) {
}
