package lk.ijse.Car_Rental_Sys_api.controller;

import lk.ijse.Car_Rental_Sys_api.dto.AdminDto;
import lk.ijse.Car_Rental_Sys_api.dto.GuestUserDto;
import lk.ijse.Car_Rental_Sys_api.service.GuestUserService;
import lk.ijse.Car_Rental_Sys_api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("guest")
@CrossOrigin
public class GuestUserController {

    @Autowired
    GuestUserService guestUserService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveGuestUser(GuestUserDto dto) {
        guestUserService.saveGuestUser(dto);
        return new ResponseUtil(200, "Saved Guest User", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllGuestUser() {
        return new ResponseUtil(200, "All Admins", guestUserService.getGuestUsers());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateGuestUser(@RequestBody GuestUserDto dto) {
        guestUserService.updateGuestUser(dto);
        return new ResponseUtil(200, "update guest user", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchGuestUser(@PathVariable String id) {
        return new ResponseUtil(200, "OK", guestUserService.searchGuestUser(id));
    }
}
