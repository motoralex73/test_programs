package com.motoralex.reservationservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> findAllByUserId(Long id);
    List<ReservationEntity> findAllByReservationStatusIs(ReservationStatus reservationStatus);
}
