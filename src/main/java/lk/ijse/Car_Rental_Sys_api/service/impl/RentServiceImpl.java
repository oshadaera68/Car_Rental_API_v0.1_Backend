package lk.ijse.Car_Rental_Sys_api.service.impl;

import lk.ijse.Car_Rental_Sys_api.dto.CarDto;
import lk.ijse.Car_Rental_Sys_api.dto.RegisterUserDto;
import lk.ijse.Car_Rental_Sys_api.dto.RentDto;
import lk.ijse.Car_Rental_Sys_api.entity.RegisterUser;
import lk.ijse.Car_Rental_Sys_api.entity.Rent;
import lk.ijse.Car_Rental_Sys_api.repo.RegisterUserRepo;
import lk.ijse.Car_Rental_Sys_api.repo.RentRepo;
import lk.ijse.Car_Rental_Sys_api.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepo repo;

    @Autowired
    private ModelMapper map3;

    @Override
    public void saveRent(RentDto dto) {
        if (!repo.existsById(dto.getRentId())) {
            repo.save(map3.map(dto, Rent.class));
        } else {
            throw new RuntimeException("This rent id is already exists....!!!");
        }
    }

    @Override
    public void updateRent(RentDto dto) {
        if (repo.existsById(dto.getRentId())) {
            repo.save(map3.map(dto, Rent.class));
        } else {
            throw new RuntimeException("This rent id is already exists....!!!");
        }
    }

    @Override
    public void deleteRent(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Not such rent id.");
        }
    }

    @Override
    public RentDto searchRent(String id) {
        if (repo.existsById(id)) {
            return map3.map(repo.findById(id).get(), RentDto.class);
        } else {
            throw new RuntimeException("No user For " + id + " ..!");
        }
    }

    @Override
    public List<RentDto> getAllRents() {
        return map3.map(repo.findAll(), new TypeToken<List<RentDto>>() {
        }.getType());
    }
}
