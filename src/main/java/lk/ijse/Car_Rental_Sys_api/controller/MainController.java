package lk.ijse.Car_Rental_Sys_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {
    @GetMapping
    public String testMethod() {
        System.out.println("Request Received");
        return "index";
    }
}
