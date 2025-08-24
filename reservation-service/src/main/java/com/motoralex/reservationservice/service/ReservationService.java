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
        reservationMap.put(id, reservationToUpdate);
        return reservationMap.get(id);
    }

    public void deleteReservation(Long id) {
        if (!reservationMap.containsKey(id)) {
            throw new NoSuchElementException("Not found reservation with id " + id);
        }
        reservationMap.remove(id);
    }
}
