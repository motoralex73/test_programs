package com.motoralex.reservationservice.repo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "room_id")
    private Long room_id;

    @Column(name = "start_date")
    private LocalDateTime start_date;

    @Column(name = "end_date")
    private LocalDateTime end_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status")
    private ReservationStatus reservation_status;

    public ReservationEntity() {
    }

    public ReservationEntity(Long id, Long user_id, Long room_id, LocalDateTime start_date, LocalDateTime end_date, ReservationStatus reservation_status) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.reservation_status = reservation_status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public ReservationStatus getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(ReservationStatus reservation_status) {
        this.reservation_status = reservation_status;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", room_id=" + room_id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", reservation_status=" + reservation_status +
                '}';
    }
}
