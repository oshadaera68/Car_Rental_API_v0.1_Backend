package lk.ijse.Car_Rental_Sys_api.service;

import lk.ijse.Car_Rental_Sys_api.dto.ReservationDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReservationService {
    void saveReservation(ReservationDto dto);

    void updateReservation(ReservationDto dto);

    void deleteReservation(String id);

    ReservationDto searchReservation(String id);

    List<ReservationDto> getAllReservations();
}
