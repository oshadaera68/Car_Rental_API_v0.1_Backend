package lk.ijse.Car_Rental_Sys_api.service;

import lk.ijse.Car_Rental_Sys_api.dto.DriverDto;
import lk.ijse.Car_Rental_Sys_api.dto.RegisterUserDto;

import java.util.List;

public interface RegisterUserService {
    void saveRegUser(RegisterUserDto dto);
    void updateRegUser(RegisterUserDto dto);
    void deleteRegUser(String id);
    RegisterUserDto searchRegUser(String id);
    List<RegisterUserDto> getAllRegUsers();
}
