/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

@Entity
public class Reservation {
    @Id
    private String resId;
    private String registerDate;
    private String returnDate;
    private int numberOfDays;
    private String cancellationDetails;
    private String pickUpDate;
}
