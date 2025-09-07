package com.motoralex.reservationservice.service;

import com.motoralex.reservationservice.repo.ReservationEntity;
import com.motoralex.reservationservice.repo.ReservationRepository;
import com.motoralex.reservationservice.repo.ReservationStatus;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationEntity findReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Reservation with id " + id + " not found"));
    }

    public List<ReservationEntity> findAllReservation() {

        System.out.println(reservationRepository.findAllByReservationStatusIs(ReservationStatus.APPROVED));
        return reservationRepository.findAll();
    }

    @Transactional
    public void createReservation(ReservationEntity reservation) {

        if (!reservation.getEndDate().isAfter(reservation.getStartDate())) {
            throw new IllegalArgumentException("Start date should be after end date");
        }

        reservationRepository.save(reservation);
        logger.info("Reservation with id " + reservation.getId() + " created");
    }

    @Transactional
    public ReservationEntity updateReservation(Long id, ReservationEntity reservationToUpdate) {

        var reservationEntity = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation with id " + id + " not found"));
        if (!reservationEntity.getReservationStatus().equals(ReservationStatus.PENDING)) {
            throw new IllegalArgumentException("Status should be pending");
        }
        if (!reservationToUpdate.getEndDate().isAfter(reservationToUpdate.getStartDate())) {
            throw new IllegalArgumentException("Start date should be after end date");
        }

        reservationRepository.save(reservationToUpdate);
        logger.info("Reservation with id " + reservationToUpdate.getId() + " updated");

        return reservationToUpdate;
    }

    @Transactional
    public void cancelReservation(Long id) {

        var reservationEntity = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation with id " + id + " not found"));

        if (reservationEntity.getReservationStatus().equals(ReservationStatus.APPROVED)) {
            throw new IllegalStateException("Reservation with id " + id + " already approved, please call manager");
        }
        if (reservationEntity.getReservationStatus().equals(ReservationStatus.CANCELLED)) {
            throw new IllegalArgumentException("Reservation has status cancelled");
        }

        reservationEntity.setReservationStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservationEntity);
        logger.info("Reservation with id " + id + " has been cancelled");
    }

    @Transactional
    public void deleteReservation(Long id) {

        if (reservationRepository.findById(id).isPresent()) {
            reservationRepository.deleteById(id);
        }
        else {
            throw new NoSuchElementException("Not found reservation with id " + id);
        }
    }

    @Transactional
    public ReservationEntity approveReservation(Long id) {

        if (reservationRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Not found reservation with id " + id);
        }

        var reservation = reservationRepository.findById(id).get();
        if (reservationRepository.findById(id).orElseThrow().getReservationStatus() != ReservationStatus.PENDING) {
            throw new IllegalStateException("Cannot approve reservation with id " + id);
        }

        var isConflict = isReservationConflict(reservation);
        if (isConflict) {
            throw new IllegalStateException("Cannot approve reservation because of conflict with id " + id);
        }

        reservation.setReservationStatus(ReservationStatus.APPROVED);
        reservationRepository.save(reservation);
        return reservation;
    }

    private boolean isReservationConflict(ReservationEntity reservation) {

        var allReservations = reservationRepository.findAll();

        for (ReservationEntity reservationEntity : allReservations) {
            if (reservation.getId().equals(reservationEntity.getId())) {
                continue;
            }
            if (!reservation.getRoomId().equals(reservationEntity.getRoomId())) {
                continue;
            }
            if (!reservationEntity.getReservationStatus().equals(ReservationStatus.APPROVED)) {
                continue;
            }
            if (reservation.getStartDate().isBefore(reservationEntity.getEndDate()) &&
                    reservationEntity.getStartDate().isBefore(reservation.getEndDate())) {
                return true;
            }
        }
        return false;
    }

}
