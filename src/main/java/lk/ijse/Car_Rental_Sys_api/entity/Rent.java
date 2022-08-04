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
    private String resid;
    @Id
    private String vid;
    private String date;
    private double unitprice;

    //Out-Verse
    @ManyToOne
    @JoinColumn(name = "resid",referencedColumnName = "resid",insertable = false,updatable = false)
    private Reservation reservation;
    //Out-verse
    @ManyToOne
    @JoinColumn(name = "cId",referencedColumnName = "cId",insertable = false,updatable = false)
    private Car car;
}