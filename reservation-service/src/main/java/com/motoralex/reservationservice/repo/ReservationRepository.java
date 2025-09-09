package com.motoralex.reservationservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    //custom methods to service layer
    List<ReservationEntity> findAllByUserId(Long id);
    List<ReservationEntity> findAllByReservationStatusIs(ReservationStatus reservationStatus);

    @Modifying
    @Query("""
            update ReservationEntity r
            set r.reservationStatus = :status
            where r.id = :id
            """)
    void setReservationStatus(
            @Param("id") Long id,
            @Param("status") ReservationStatus reservationStatus
    );

    @Query("""
            select r.id from ReservationEntity r
            where r.roomId = :roomId
            and :startDate < r.endDate
            and r.startDate = :endDate
            and r.reservationStatus = :status
        """)
    List<Long> findConflictReservationIds(
            Long roomId,
            LocalDateTime startDate,
            LocalDateTime endDate,
            ReservationStatus status
    );
}
