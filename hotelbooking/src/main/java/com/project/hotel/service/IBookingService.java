/**
 * 
 */
package com.project.hotel.service;

import java.util.List;

import com.project.hotel.exception.DataNotFoundException;
import com.project.hotel.exception.RoomsNotAvailableException;
import com.project.hotel.model.dto.BookingResponseVO;
import com.project.hotel.model.dto.CityVO;
import com.project.hotel.model.dto.HotelVO;
import com.project.hotel.model.dto.LeastPricedHotelVO;
import com.project.hotel.web.BookRoom;

/**
 * @author pnayak
 *
 */
public interface IBookingService {

	List<CityVO> findAllCities() throws DataNotFoundException;
	List<HotelVO> findHotelsByCity(Integer cityId) throws DataNotFoundException;
	BookingResponseVO bookRoom(BookRoom bookRoom) throws RoomsNotAvailableException;
	List<LeastPricedHotelVO> findLeastPricedHotelsByCity(CityVO cityVO);
	
	
}
