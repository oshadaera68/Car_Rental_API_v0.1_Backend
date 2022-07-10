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
public class RentDto {
    private String rentId;
    private String paymentMethod;
    private String paymentDate;
    private int damagesCompensiation;
    private double refund;
    private double downPayment;
    private double totalPayment;
}
