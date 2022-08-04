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
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

@Entity
public class Reservation {
    @Id
    private String resId;
    private LocalDate date;
    private int noOfDays;
    private String pickUpDate;

    //Out=verse in guestcustomer
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "guestId", referencedColumnName = "guestId", insertable = false, updatable = false)
    private GuestUser guestuser;

    //Out=verse in regcustomer
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "regId", referencedColumnName = "regId", insertable = false, updatable = false)
    private RegisterUser regUser;

}
