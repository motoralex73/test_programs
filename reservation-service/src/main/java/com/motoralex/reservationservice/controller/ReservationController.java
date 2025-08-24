package com.motoralex.reservationservice.controller;

import com.motoralex.reservationservice.repo.Reservation;
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
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id) {
        log.info("Get reservation by id: " + id);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(reservationService.findById(id));
        }
        catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Reservation>> getAllReservations() {
        log.info("Get all reservations");
        return ResponseEntity.ok(reservationService.findAllReservation());
    }

    @PostMapping()
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservationToCreate) {
        log.info("Create reservation: " + reservationToCreate);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("test-header","123")
                .body(reservationService.createReservation(reservationToCreate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") Long id,
                                                         @RequestBody Reservation reservationToUpdate) {
        log.info("Update reservation id = " + id + "reservationToUpdate = " + reservationToUpdate);
        var updated = reservationService.updateReservation(id, reservationToUpdate);
        return ResponseEntity.ok((Reservation) updated);
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
}
