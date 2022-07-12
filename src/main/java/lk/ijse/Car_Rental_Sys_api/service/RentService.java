package lk.ijse.Car_Rental_Sys_api.service;

import lk.ijse.Car_Rental_Sys_api.dto.RegisterUserDto;
import lk.ijse.Car_Rental_Sys_api.dto.RentDto;

import java.util.List;

public interface RentService {
    void saveRent(RentDto dto);
    void updateRent(RentDto dto);
    void deleteRent(String id);
    RentDto searchRent(String id);
    List<RentDto> getAllRents();
}
