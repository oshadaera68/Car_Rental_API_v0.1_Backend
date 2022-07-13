package lk.ijse.Car_Rental_Sys_api.service.impl;

import lk.ijse.Car_Rental_Sys_api.config.WebAppConfig;
import lk.ijse.Car_Rental_Sys_api.dto.AdminDto;
import lk.ijse.Car_Rental_Sys_api.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class AdminServiceImplTest {

    @Autowired
    AdminService adminService;

    public AdminDto addOneAdmin() {
        return new AdminDto("A001", "ashan", "galle", "071");
    }

    public void addAdmins(){
        AdminDto a1 = new AdminDto("A001", "nimesh", "galle", "091");
        AdminDto a2 = new AdminDto("A002", "anodya", "ahangama", "091");
        AdminDto a3 = new AdminDto("A003", "ahesh", "galle", "071");
        AdminDto a4 = new AdminDto("A004", "ashan", "galle", "071");
        adminService.saveAdmin(a1);
        adminService.saveAdmin(a2);
        adminService.saveAdmin(a3);
        adminService.saveAdmin(a4);
    }

    @Test
    void saveAdmin() {
        AdminDto adminDto = addOneAdmin();
        assertDoesNotThrow(() -> {
            adminService.saveAdmin(adminDto);
        });

        AdminDto adminDto1 =addOneAdmin();
        assertThrows(RuntimeException.class, () -> {
            adminService.saveAdmin(adminDto1);
        });
    }

    @Test
    void updateAdmin() {
        //Add multiple customers
        addAdmins();

        //update an existing customer
        assertDoesNotThrow(()->{
            adminService.updateAdmin(new AdminDto("A001","kavindu","galle","091"));
        });

        //update an non existing customer
        //should throw an exception
        assertThrows(RuntimeException.class,()->{
            adminService.updateAdmin(new AdminDto("A021","kavindu","galle","091"));
        });
    }

    @Test
    void deleteAdmin() {
        addAdmins();
        assertDoesNotThrow(()->{
            adminService.deleteAdmin("A001");
        });

        assertThrows(RuntimeException.class,()->{
            adminService.deleteAdmin("A021");
        });

    }

    @Test
    void searchAdmin() {
        AdminDto admin = addOneAdmin();
        adminService.saveAdmin(admin);

        AdminDto c001 = adminService.searchAdmin("A001");
        assertNotNull(c001);

        assertThrows(RuntimeException.class, () -> {
            AdminDto c002 = adminService.searchAdmin("A012");
        });
    }

    @Test
    void getAllAdmins() {
        addAdmins();

        List<AdminDto> allCustomers = adminService.getAllAdmins();
        for (AdminDto allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }

        assertNotNull(allCustomers);
    }
}