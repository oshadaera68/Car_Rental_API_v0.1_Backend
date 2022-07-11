/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.service.impl;

import lk.ijse.Car_Rental_Sys_api.dto.CarDto;
import lk.ijse.Car_Rental_Sys_api.dto.DriverDto;
import lk.ijse.Car_Rental_Sys_api.entity.Car;
import lk.ijse.Car_Rental_Sys_api.repo.CarRepo;
import lk.ijse.Car_Rental_Sys_api.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper map2;

    @Override
    public void saveCar(CarDto dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(map2.map(dto, Car.class));
        } else {
            throw new RuntimeException("This car id is already exists....!!!");
        }
    }

    @Override
    public void updateCar(CarDto dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(map2.map(dto, Car.class));
        } else {
            throw new RuntimeException("This car id is already exists....!!!");
        }
    }

    @Override
    public void deleteCar(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Not such car id.");
        }
    }

    @Override
    public CarDto searchCar(String id) {
        if (repo.existsById(id)) {
            return map2.map(repo.findById(id).get(), CarDto.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public List<CarDto> getAllCars() {
        return map2.map(repo.findAll(), new TypeToken<List<CarDto>>() {
        }.getType());
    }
}
