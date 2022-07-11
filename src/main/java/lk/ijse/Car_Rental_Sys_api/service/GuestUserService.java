package lk.ijse.Car_Rental_Sys_api.service;

import lk.ijse.Car_Rental_Sys_api.dto.GuestUserDto;

import java.util.List;

public interface GuestUserService {
    void saveGuestUser(GuestUserDto dto);

    void updateGuestUser(GuestUserDto dto);

    void deleteGuestUser(String id);

    GuestUserDto searchGuestUser(String id);

    List<GuestUserDto> getGuestUsers();
}
