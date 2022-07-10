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
public class Rent {
    @Id
    private String rentId;
    private String paymentMethod;
    private String paymentDate;
    private int damagesCompensiation;
    private double refund;
    private double downPayment;
    private double totalPayment;
}
