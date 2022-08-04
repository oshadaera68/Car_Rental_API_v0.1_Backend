package lk.ijse.Car_Rental_Sys_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderCar_PK implements Serializable {
    private String resId;
    private String id;
}
