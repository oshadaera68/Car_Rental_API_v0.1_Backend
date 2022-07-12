package lk.ijse.Car_Rental_Sys_api.service.impl;

import lk.ijse.Car_Rental_Sys_api.dto.CarDto;
import lk.ijse.Car_Rental_Sys_api.dto.DriverDto;
import lk.ijse.Car_Rental_Sys_api.dto.RegisterUserDto;
import lk.ijse.Car_Rental_Sys_api.entity.RegisterUser;
import lk.ijse.Car_Rental_Sys_api.repo.RegisterUserRepo;
import lk.ijse.Car_Rental_Sys_api.service.RegisterUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    private RegisterUserRepo repo;

    @Autowired
    private ModelMapper map3;


    @Override
    public void saveRegUser(RegisterUserDto dto) {
        if (!repo.existsById(dto.getGuestId())) {
            repo.save(map3.map(dto, RegisterUser.class));
        } else {
            throw new RuntimeException("This user id is already exists....!!!");
        }
    }

    @Override
    public void updateRegUser(RegisterUserDto dto) {
        if (repo.existsById(dto.getGuestId())) {
            repo.save(map3.map(dto, RegisterUser.class));
        } else {
            throw new RuntimeException("This user id is already exists....!!!");
        }
    }

    @Override
    public void deleteRegUser(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Not such user id.");
        }
    }

    @Override
    public RegisterUserDto searchRegUser(String id) {
        if (repo.existsById(id)) {
            return map3.map(repo.findById(id).get(), RegisterUserDto.class);
        } else {
            throw new RuntimeException("No user For " + id + " ..!");
        }
    }

    @Override
    public List<RegisterUserDto> getAllRegUsers() {
        return map3.map(repo.findAll(), new TypeToken<List<DriverDto>>() {
        }.getType());
    }
}
