package lk.ijse.Car_Rental_Sys_api.service.impl;

import lk.ijse.Car_Rental_Sys_api.dto.DriverDto;
import lk.ijse.Car_Rental_Sys_api.dto.RegisterUserDto;
import lk.ijse.Car_Rental_Sys_api.dto.ReservationDto;
import lk.ijse.Car_Rental_Sys_api.entity.Driver;
import lk.ijse.Car_Rental_Sys_api.entity.Reservation;
import lk.ijse.Car_Rental_Sys_api.repo.DriverRepo;
import lk.ijse.Car_Rental_Sys_api.repo.ReservationRepo;
import lk.ijse.Car_Rental_Sys_api.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepo repo;

    @Autowired
    private ModelMapper map1;

    @Override
    public void saveReservation(ReservationDto dto) {
        if (!repo.existsById(dto.getResId())) {
            repo.save(map1.map(dto, Reservation.class));
        } else {
            throw new RuntimeException("This reservation id is already exists....!!!");
        }
    }


    @Override
    public void updateReservation(ReservationDto dto) {
        if (repo.existsById(dto.getResId())) {
            repo.save(map1.map(dto, Reservation.class));
        } else {
            throw new RuntimeException("This Driver id is already exists....!!!");
        }
    }

    @Override
    public void deleteReservation(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Empty Driver...!");
        }
    }

    @Override
    public ReservationDto searchReservation(String id) {
        if (repo.existsById(id)) {
            return map1.map(repo.findById(id).get(), ReservationDto.class);
        } else {
            throw new RuntimeException("No Driver For " + id + " ..!");
        }
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        return map1.map(repo.findAll(), new TypeToken<List<ReservationDto>>() {
        }.getType());
    }

}
