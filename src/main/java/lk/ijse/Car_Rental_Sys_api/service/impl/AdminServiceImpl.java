/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.service.impl;

import lk.ijse.Car_Rental_Sys_api.dto.AdminDto;
import lk.ijse.Car_Rental_Sys_api.dto.CarDto;
import lk.ijse.Car_Rental_Sys_api.entity.Admin;
import lk.ijse.Car_Rental_Sys_api.repo.AdminRepo;
import lk.ijse.Car_Rental_Sys_api.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper map4;

    @Override
    public void saveAdmin(AdminDto dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(map4.map(dto, Admin.class));
        } else {
            throw new RuntimeException("This user id is already exists....!!!");
        }
    }

    @Override
    public void updateAdmin(AdminDto dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(map4.map(dto, Admin.class));
        } else {
            throw new RuntimeException("This user id is already exists....!!!");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Not such user id.");
        }
    }

    @Override
    public AdminDto searchAdmin(String id) {
        if (repo.existsById(id)) {
            return map4.map(repo.findById(id).get(), AdminDto.class);
        } else {
            throw new RuntimeException("No user For " + id + " ..!");
        }
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        return map4.map(repo.findAll(), new TypeToken<List<CarDto>>() {
        }.getType());
    }
}
