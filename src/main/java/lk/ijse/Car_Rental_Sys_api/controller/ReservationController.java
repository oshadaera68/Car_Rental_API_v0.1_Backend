package lk.ijse.Car_Rental_Sys_api.controller;

import lk.ijse.Car_Rental_Sys_api.dto.ReservationDto;
import lk.ijse.Car_Rental_Sys_api.service.ReservationService;
import lk.ijse.Car_Rental_Sys_api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveReservation(ReservationDto dto) {
        reservationService.saveReservation(dto);
        return new ResponseUtil(200, "Saved Admin", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllReservations() {
        return new ResponseUtil(200, "All Admins", reservationService.getAllReservations());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateReservations(@RequestBody ReservationDto dto) {
        reservationService.updateReservation(dto);
        return new ResponseUtil(200, "update admin", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchReservation(@PathVariable String id) {
        return new ResponseUtil(200, "OK", reservationService.searchReservation(id));
    }
}