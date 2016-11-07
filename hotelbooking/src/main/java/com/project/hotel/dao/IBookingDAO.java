/**
 * 
 */
package com.project.hotel.dao;

import java.util.Date;
import java.util.List;

import com.project.hotel.model.TbookedRoomDetails;
import com.project.hotel.model.TbookingUser;
import com.project.hotel.model.Tcity;
import com.project.hotel.model.Thotel;
import com.project.hotel.model.dto.CityVO;

/**
 * @author pnayak
 *
 */
public interface IBookingDAO {

	List<Tcity> findAllCities();
	List<Thotel> findHotelsByCity(Integer cityId);
	List<Thotel> findLeastPricedHotelsByCity(CityVO cityVO);
	List<TbookedRoomDetails> findBookedRoomsByHotel(Integer hotelId,Date checkinDate,Date checkoutDate);
	Thotel findHotelById(Integer hoteld);
	 // saveBookedRooms
	TbookingUser saveBookingUserDetails(TbookingUser bookingUser);
	void saveBookedRoomDetails(TbookedRoomDetails bookedRooms);
}
