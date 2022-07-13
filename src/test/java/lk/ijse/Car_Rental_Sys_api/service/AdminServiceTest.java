package lk.ijse.Car_Rental_Sys_api.service;

import lk.ijse.Car_Rental_Sys_api.config.JPAConfig;
import lk.ijse.Car_Rental_Sys_api.dto.AdminDto;
import lk.ijse.Car_Rental_Sys_api.entity.Admin;
import lk.ijse.Car_Rental_Sys_api.repo.AdminRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
//@Transactional
class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    void saveAdmin() {
        AdminDto c1 = new AdminDto("A001","Dasun","Galle","36374");
        AdminDto c2 = new AdminDto("A002","Kamal","Panadura","34537");
        AdminDto c3 = new AdminDto("A003","Ramal","Kaluthara","674338");
        AdminDto c4 = new AdminDto("A004","Oshan","Colombo","5548545");
        adminService.saveAdmin(c1);
        adminService.saveAdmin(c2);
        adminService.saveAdmin(c3);
        adminService.saveAdmin(c4);
    }

    @Test
    void updateAdmin() {
        AdminDto admin = new AdminDto("A001","nimesh","ahangama","071");
        adminService.saveAdmin(admin);
    }

    @Test
    void deleteAdmin() {
        adminService.deleteAdmin("A001");
    }

    @Test
    void searchAdmin() {
        adminService.searchAdmin("A002");
    }

    @Test
    void getAllAdmins() {
        List<AdminDto> allAdmins = adminService.getAllAdmins();
        for (AdminDto allAdmin : allAdmins) {
            System.out.println(allAdmin.toString());
        }
    }
}