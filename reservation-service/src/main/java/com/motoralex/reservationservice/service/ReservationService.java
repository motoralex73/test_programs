package com.motoralex.reservationservice.service;

import com.motoralex.reservationservice.repo.Reservation;
import com.motoralex.reservationservice.repo.ReservationStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ReservationService {

    private final Map<Long, Reservation> reservationMap;
    private final AtomicLong idCounter;

    public ReservationService() {
        reservationMap = new HashMap<>();
        idCounter = new AtomicLong();
    }

    public Reservation findById(Long id) {
        if (!reservationMap.containsKey(id)) {
            throw new NoSuchElementException("Not found reservation with id " + id);
        }
        return reservationMap.get(id);
    }

    public List<Reservation> findAllReservation() {
        return reservationMap.values().stream().toList();
    }

    public Reservation createReservation(Reservation reservation) {
        if (reservation.id() == null)  {
            throw new IllegalArgumentException("Id should not be null");
        }

        var newReservation = new Reservation(
                idCounter.incrementAndGet(),
                reservation.userId(),
                reservation.roomId(),
                reservation.startDate(),
                reservation.endDate(),
                ReservationStatus.PENDING
        );
        reservationMap.put(newReservation.id(), newReservation);
        return newReservation;
    }

    public Reservation updateReservation(Long id, Reservation reservationToUpdate) {
        if (!reservationMap.containsKey(id)) {
            throw new NoSuchElementException("Not found reservation with id " + id);
        }
        var reservation = reservationMap.get(id);
        if (reservation.reservationStatus() != ReservationStatus.PENDING) {
            throw new IllegalStateException("Cannot update reservation with id " + id);
        }
        var updatedReservation = new Reservation(
                reservation.id(),
                reservationToUpdate.userId(),
                reservationToUpdate.roomId(),
                reservationToUpdate.startDate(),
                reservationToUpdate.endDate(),
                ReservationStatus.PENDING
        );
        reservationMap.put(id, updatedReservation);
        return updatedReservation;
    }

    public void deleteReservation(Long id) {
        if (!reservationMap.containsKey(id)) {
            throw new NoSuchElementException("Not found reservation with id " + id);
        }
        reservationMap.remove(id);
    }

    public Reservation approveReservation(Long id) {

        if (!reservationMap.containsKey(id)) {
            throw new NoSuchElementException("Not found reservation with id " + id);
        }

        var reservation = reservationMap.get(id);
        if (reservation.reservationStatus() != ReservationStatus.PENDING) {
            throw new IllegalStateException("Cannot approve reservation with id " + id);
        }

        var isConflict = isReservationConflict(reservation);
        if (isConflict) {
            throw new IllegalStateException("Cannot approve reservation because of conflict with id " + id);
        }

        var approvedReservation = new Reservation(
                reservation.id(),
                reservation.userId(),
                reservation.roomId(),
                reservation.startDate(),
                reservation.endDate(),
                ReservationStatus.APPROVED
        );
        reservationMap.put(id, approvedReservation);
        return approvedReservation;
    }

    private boolean isReservationConflict(Reservation reservation) {
        for (Reservation e : reservationMap.values()) {
            if (reservation.id().equals(e.id())) {
                continue;
            }
            if (!reservation.roomId().equals(e.roomId())) {
                continue;
            }
            if (!e.reservationStatus().equals(ReservationStatus.APPROVED)) {
                continue;
            }
            if (reservation.startDate().isBefore(e.endDate()) && e.startDate().isBefore(reservation.endDate())) {
                return true;
            }
        }
        return false;
    }
}
