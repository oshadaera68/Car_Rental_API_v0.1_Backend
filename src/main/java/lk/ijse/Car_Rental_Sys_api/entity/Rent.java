/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

@Entity
@IdClass(OrderCar_PK.class)
public class Rent {
    @Id
    private String rentId;
    @Id
    private String id;
    private String date;
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "resId",referencedColumnName = "resId",insertable = false,updatable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id",insertable = false,updatable = false)
    private Car car;
}
