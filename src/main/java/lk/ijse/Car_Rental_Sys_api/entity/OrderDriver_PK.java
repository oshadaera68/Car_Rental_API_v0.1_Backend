package lk.ijse.Car_Rental_Sys_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDriver_PK implements Serializable {
    private String cId;
    private String id;

}
