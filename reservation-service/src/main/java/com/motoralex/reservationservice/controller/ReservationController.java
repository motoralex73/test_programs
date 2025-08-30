package com.motoralex.reservationservice.controller;

import com.motoralex.reservationservice.repo.ReservationEntity;
import com.motoralex.reservationservice.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private static final Logger log = Logger.getLogger(ReservationController.class.getName());

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationEntity> getReservationById(@PathVariable("id") Long id) {
        log.info("Get reservation by id: " + id);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(reservationService.findReservationById(id));
        }
        catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<ReservationEntity>> getAllReservations() {
        log.info("Get all reservations");
        return ResponseEntity.ok(reservationService.findAllReservation());
    }

    @PostMapping()
    public ResponseEntity<ReservationEntity> createReservation(@RequestBody ReservationEntity reservationToCreate) {
        log.info("Create new reservation: " + reservationToCreate.toString());
        reservationService.createReservation(reservationToCreate);
        return ResponseEntity.ok(reservationToCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationEntity> updateReservation(@PathVariable("id") Long id,
                                                         @RequestBody ReservationEntity reservationToUpdate) {
        log.info("Update reservation id = " + id + " reservationToUpdate = " + reservationToUpdate);
        var updated = reservationService.updateReservation(id, reservationToUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Long id) {
        log.info("Delete reservation: id={}" + id);
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{id}/approved")
    public ResponseEntity<ReservationEntity> approveReservation(@PathVariable("id") Long id) {
        log.info("Approve reservation: id = " + id);
        var reservation = reservationService.approveReservation(id);
        return ResponseEntity.ok(reservation);
    }
}
