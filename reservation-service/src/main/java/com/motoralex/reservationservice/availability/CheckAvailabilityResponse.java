package com.motoralex.reservationservice.availability;

public record CheckAvailabilityResponse(
    String message,
    AvailabilityStatus status
) {
}
