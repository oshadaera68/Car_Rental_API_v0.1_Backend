/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.Car_Rental_Sys_api.repo;

import lk.ijse.Car_Rental_Sys_api.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepo extends JpaRepository<Rent, String> {
}
