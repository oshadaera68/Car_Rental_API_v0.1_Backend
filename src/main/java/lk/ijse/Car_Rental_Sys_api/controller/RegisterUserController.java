package lk.ijse.Car_Rental_Sys_api.controller;

import lk.ijse.Car_Rental_Sys_api.dto.RegisterUserDto;
import lk.ijse.Car_Rental_Sys_api.service.RegisterUserService;
import lk.ijse.Car_Rental_Sys_api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class RegisterUserController {
    @Autowired
    RegisterUserService registerUserService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveRegUser(RegisterUserDto dto) {
        registerUserService.saveRegUser(dto);
        return new ResponseUtil(200, "Saved User", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRegUser() {
        return new ResponseUtil(200, "All users", registerUserService.getAllRegUsers());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRegUser(@RequestBody RegisterUserDto dto) {
        registerUserService.updateRegUser(dto);
        return new ResponseUtil(200, "update admin", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRegUser(@PathVariable String id) {
        return new ResponseUtil(200, "OK", registerUserService.searchRegUser(id));
    }
}
