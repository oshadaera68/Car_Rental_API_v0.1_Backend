package lk.ijse.Car_Rental_Sys_api.service.impl;

import lk.ijse.Car_Rental_Sys_api.dto.DriverDto;
import lk.ijse.Car_Rental_Sys_api.dto.GuestUserDto;
import lk.ijse.Car_Rental_Sys_api.entity.Driver;
import lk.ijse.Car_Rental_Sys_api.entity.GuestUser;
import lk.ijse.Car_Rental_Sys_api.repo.DriverRepo;
import lk.ijse.Car_Rental_Sys_api.repo.GuestUserRepo;
import lk.ijse.Car_Rental_Sys_api.service.GuestUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class GuestUserServiceImpl implements GuestUserService {

    @Autowired
    private GuestUserRepo repo;

    @Autowired
    private ModelMapper map1;

    @Override
    public void saveGuestUser(GuestUserDto dto) {
        if (!repo.existsById(dto.getGuestId())) {
            repo.save(map1.map(dto, GuestUser.class));
        } else {
            throw new RuntimeException("This customer id is already exists....!!!");
        }
    }

    @Override
    public void updateGuestUser(GuestUserDto dto) {
        if (repo.existsById(dto.getGuestId())) {
            repo.save(map1.map(dto, GuestUser.class));
        } else {
            throw new RuntimeException("This customer id is already exists....!!!");
        }
    }

    @Override
    public void deleteGuestUser(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Empty Customer...!");
        }
    }

    @Override
    public GuestUserDto searchGuestUser(String id) {
        if (repo.existsById(id)) {
            return map1.map(repo.findById(id).get(), GuestUserDto.class);
        } else {
            throw new RuntimeException("No Driver For " + id + " ..!");
        }
    }

    @Override
    public List<GuestUserDto> getGuestUsers() {
        return map1.map(repo.findAll(), new TypeToken<List<GuestUserDto>>() {
        }.getType());
    }
}
