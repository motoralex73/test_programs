        package com.motoralex.reservationservice.repo;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    @Null
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    @NotNull
    private Long userId;

    @Column(name = "room_id", nullable = false, unique = true)
    @NotNull
    private Long roomId;

    @Column(name = "start_date", nullable = false)
    @FutureOrPresent
    @NotNull
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    @FutureOrPresent
    @NotNull
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus reservationStatus;

    public ReservationEntity() {
    }

    public ReservationEntity(Long id, Long userId, Long roomId, LocalDateTime startDate, LocalDateTime endDate, ReservationStatus reservationStatus) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationStatus = reservationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", roomId=" + roomId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
