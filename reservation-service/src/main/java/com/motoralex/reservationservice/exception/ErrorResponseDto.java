package com.motoralex.reservationservice.exception;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        String message,
        String detailMessage,
        LocalDateTime errorTime
) { }
