package lk.ijse.Car_Rental_Sys_api.controller;

import lk.ijse.Car_Rental_Sys_api.dto.CarDto;
import lk.ijse.Car_Rental_Sys_api.service.CarService;
import lk.ijse.Car_Rental_Sys_api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveCar(CarDto dto) {
        carService.saveCar(dto);
        return new ResponseUtil(200, "Saved Car", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCars() {
        return new ResponseUtil(200, "All car", carService.getAllCars());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDto dto) {
        carService.updateCar(dto);
        return new ResponseUtil(200, "update car", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@PathVariable String id) {
        return new ResponseUtil(200, "OK", carService.searchCar(id));
    }
}
