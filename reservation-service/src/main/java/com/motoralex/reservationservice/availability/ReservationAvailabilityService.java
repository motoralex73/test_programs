package com.motoralex.reservationservice.availability;

import com.motoralex.reservationservice.repo.ReservationRepository;
import com.motoralex.reservationservice.repo.ReservationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationAvailabilityService {
    private final ReservationRepository reservationRepository;
    private static final Logger logger = LoggerFactory.getLogger(ReservationAvailabilityService.class.getName());

    public ReservationAvailabilityService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public boolean isReservationAvailable(
            Long roomId,
            LocalDateTime startDate,
            LocalDateTime endDate
    ) {

        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("Start date should be after end date");
        }

        List<Long> conflictingIds = reservationRepository.findConflictReservationIds(
                roomId,
                startDate,
                endDate,
                ReservationStatus.APPROVED);
        if (conflictingIds.isEmpty()) {
            return true;
        }
        logger.info("Conflicting reservation ids " + conflictingIds);
        return false;
    }
}
