/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.service;

import lk.ijse.Car_Rental_Sys_api.dto.AdminDto;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDto dto);
    void updateAdmin(AdminDto dto);
    void deleteAdmin(String id);
    AdminDto searchAdmin(String id);
    List<AdminDto> getAllAdmins();
}
