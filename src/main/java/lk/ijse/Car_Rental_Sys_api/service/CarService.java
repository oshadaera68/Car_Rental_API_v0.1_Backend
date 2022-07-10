/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.service;

import lk.ijse.Car_Rental_Sys_api.dto.CarDto;
import lk.ijse.Car_Rental_Sys_api.dto.DriverDto;

import java.util.List;

public interface CarService {
    void saveCar(CarDto dto);
    void updateCar(CarDto dto);
    void deleteCar(String id);
    CarDto searchCar(String id);
    List<CarDto> getAllCars();
}
