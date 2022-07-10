/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.service;

import lk.ijse.Car_Rental_Sys_api.dto.AdminDto;
import lk.ijse.Car_Rental_Sys_api.dto.DriverDto;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDto dto);
    void updateDriver(DriverDto dto);
    void deleteDriver(String id);
    DriverDto searchDriver(String id);
    List<DriverDto> getAllDrivers();
}
