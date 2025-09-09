package com.motoralex.reservationservice.availability;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation/availability")
public class ReservationAvailabilityController {
    private static final Logger log = LoggerFactory.getLogger(ReservationAvailabilityController.class);
    private final ReservationAvailabilityService service;

    public ReservationAvailabilityController(ReservationAvailabilityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CheckAvailabilityResponse> checkAvailability(@Valid CheckAvailabilityRequest request) {
        log.info("Check availability request: {}", request);
        boolean isAvailable = service.isReservationAvailable(request.roomId(), request.startDate(), request.endDate());
        var message = isAvailable ? "Room available" : "Room not available";
        var status = isAvailable ? AvailabilityStatus.AVAILABLE : AvailabilityStatus.RESERVED;
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new CheckAvailabilityResponse(message,status));
    }
}
