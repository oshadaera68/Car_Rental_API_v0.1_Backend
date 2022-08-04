/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReservationDto {
    private String resId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerDate;
    private GuestUserDto guestUserDto;
    private RegisterUserDto registerUserDto;
    List<RentDto> rentDtoList;
}
