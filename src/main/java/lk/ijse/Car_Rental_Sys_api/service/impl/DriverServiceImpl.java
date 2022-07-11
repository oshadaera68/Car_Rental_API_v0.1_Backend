/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.service.impl;

import lk.ijse.Car_Rental_Sys_api.dto.DriverDto;
import lk.ijse.Car_Rental_Sys_api.entity.Driver;
import lk.ijse.Car_Rental_Sys_api.repo.DriverRepo;
import lk.ijse.Car_Rental_Sys_api.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper map1;

    @Override
    public void saveDriver(DriverDto dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(map1.map(dto, Driver.class));
        } else {
            throw new RuntimeException("This Driver id is already exists....!!!");
        }
    }

    @Override
    public void updateDriver(DriverDto dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(map1.map(dto, Driver.class));
        } else {
            throw new RuntimeException("This Driver id is already exists....!!!");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Empty Driver...!");
        }
    }

    @Override
    public DriverDto searchDriver(String id) {
        if (repo.existsById(id)) {
            return map1.map(repo.findById(id).get(), DriverDto.class);
        } else {
            throw new RuntimeException("No Driver For " + id + " ..!");
        }
    }

    @Override
    public List<DriverDto> getAllDrivers() {
        return map1.map(repo.findAll(), new TypeToken<List<DriverDto>>() {
        }.getType());
    }
}
