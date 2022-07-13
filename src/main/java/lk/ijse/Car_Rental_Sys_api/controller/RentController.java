package lk.ijse.Car_Rental_Sys_api.controller;

import lk.ijse.Car_Rental_Sys_api.dto.AdminDto;
import lk.ijse.Car_Rental_Sys_api.dto.RentDto;
import lk.ijse.Car_Rental_Sys_api.service.RentService;
import lk.ijse.Car_Rental_Sys_api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public class RentController {
    @Autowired
    RentService rentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveRent(RentDto dto) {
        rentService.saveRent(dto);
        return new ResponseUtil(200, "Saved Admin", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRents() {
        return new ResponseUtil(200, "All Admins", rentService.getAllRents());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody RentDto dto) {
        rentService.updateRent(dto);
        return new ResponseUtil(200, "update admin", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@PathVariable String id) {
        return new ResponseUtil(200, "OK", rentService.searchRent(id));
    }
}
