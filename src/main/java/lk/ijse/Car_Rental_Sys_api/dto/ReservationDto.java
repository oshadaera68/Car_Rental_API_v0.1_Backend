/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReservationDto {
    private String resId;
    private String registerDate;
    private String returnDate;
    private int numberOfDays;
    private String cancellationDetails;
    private String pickUpDate;
}
