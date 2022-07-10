/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.service.impl;

import lk.ijse.Car_Rental_Sys_api.dto.AdminDto;
import lk.ijse.Car_Rental_Sys_api.service.AdminService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Override
    public void saveAdmin(AdminDto dto) {

    }

    @Override
    public void updateAdmin(AdminDto dto) {

    }

    @Override
    public void deleteAdmin(String id) {

    }

    @Override
    public AdminDto searchAdmin(String id) {
        return null;
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        return null;
    }
}
