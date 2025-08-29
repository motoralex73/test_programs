package com.motoralex.reservationservice.service;

import com.motoralex.reservationservice.repo.ReservationEntity;
import com.motoralex.reservationservice.repo.ReservationRepository;
import com.motoralex.reservationservice.repo.ReservationStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationEntity findReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<ReservationEntity> findAllReservation() {
        return reservationRepository.findAll();
    }

    @Transactional
    public void createReservation(ReservationEntity reservation) {
            reservationRepository.save(reservation);
    }

    //@Transactional
    public ReservationEntity updateReservation(Long id, ReservationEntity reservationToUpdate) {
        if (id != null && reservationRepository.findById(id).isPresent()) {
            reservationToUpdate.setId(id);
            reservationRepository.save(reservationToUpdate);
            return reservationToUpdate;
        }
        return null;
    }

    //@Transactional
    public void deleteReservation(Long id) {
        if (reservationRepository.findById(id).isPresent()) {
            reservationRepository.deleteById(id);
        }
        else {
            throw new NoSuchElementException("Not found reservation with id " + id);
        }
    }

//    public Reservation approveReservation(Long id) {
//
//        if (!reservationMap.containsKey(id)) {
//            throw new NoSuchElementException("Not found reservation with id " + id);
//        }
//
//        var reservation = reservationMap.get(id);
//        if (reservation.reservationStatus() != ReservationStatus.PENDING) {
//            throw new IllegalStateException("Cannot approve reservation with id " + id);
//        }

//        var isConflict = isReservationConflict(reservation);
//        if (isConflict) {
//            throw new IllegalStateException("Cannot approve reservation because of conflict with id " + id);
//        }

//        var approvedReservation = new Reservation(
//                reservation.id(),
//                reservation.userId(),
//                reservation.roomId(),
//                reservation.startDate(),
//                reservation.endDate(),
//                ReservationStatus.APPROVED
//        );
//        reservationMap.put(id, approvedReservation);
//        return approvedReservation;
//    }
//
//    private boolean isReservationConflict(Reservation reservation) {
//        for (Reservation e : reservationMap.values()) {
//            if (reservation.id().equals(e.id())) {
//                continue;
//            }
//            if (!reservation.roomId().equals(e.roomId())) {
//                continue;
//            }
//            if (!e.reservationStatus().equals(ReservationStatus.APPROVED)) {
//                continue;
//            }
//            if (reservation.startDate().isBefore(e.endDate()) && e.startDate().isBefore(reservation.endDate())) {
//                return true;
//            }
//        }
//        return false;
//    }
}
