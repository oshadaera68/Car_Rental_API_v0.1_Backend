package lk.ijse.Car_Rental_Sys_api.service;

import lk.ijse.Car_Rental_Sys_api.config.JPAConfig;
import lk.ijse.Car_Rental_Sys_api.entity.Admin;
import lk.ijse.Car_Rental_Sys_api.repo.AdminRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
//@Transactional
class AdminServiceTest {

    @Autowired
    AdminRepo adminRepo;

    @Test
    void saveAdmin() {
        Admin admin = new Admin("A001","ashan","ahangama","071");
        adminRepo.save(admin);
    }

    @Test
    void updateAdmin() {
    }

    @Test
    void deleteAdmin() {
    }

    @Test
    void searchAdmin() {
    }

    @Test
    void getAllAdmins() {
    }
}