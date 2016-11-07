/**
 * 
 */
package com.project.hotel.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.project.hotel.dao.IBookingDAO;
import com.project.hotel.exception.DataNotFoundException;
import com.project.hotel.exception.RoomsNotAvailableException;
import com.project.hotel.model.TbookedRoomDetails;
import com.project.hotel.model.TbookingUser;
import com.project.hotel.model.Tcity;
import com.project.hotel.model.Thotel;
import com.project.hotel.model.dto.BookingResponseVO;
import com.project.hotel.model.dto.CityVO;
import com.project.hotel.model.dto.HotelVO;
import com.project.hotel.model.dto.LeastPricedHotelVO;
import com.project.hotel.web.BookRoom;

/**
 * @author pnayak
 *
 */
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingDAO bookingDAO;

	@Override
	public List<CityVO> findAllCities() throws DataNotFoundException {
		List<Tcity> cityList = bookingDAO.findAllCities();
		List<CityVO> cityVOs = new ArrayList<CityVO>();
		if (cityList.isEmpty()) {
			throw new DataNotFoundException(" No cities are exist");
		} else {
			for (Tcity city : cityList) {
				cityVOs.add(new CityVO(city.getCityId(), city.getCityNm()));
			}
		}
		return cityVOs;
	}

	@Override
	public List<HotelVO> findHotelsByCity(Integer cityId) throws DataNotFoundException {

		List<Thotel> hotelList = bookingDAO.findHotelsByCity(cityId);
		List<HotelVO> hotelVOs = new ArrayList<HotelVO>();
		if (hotelList.isEmpty()) {
			throw new DataNotFoundException(" No hotels are exist");
		} else {
			for (Thotel hotel : hotelList) {
				hotelVOs.add(new HotelVO(hotel.getHotelId(), hotel.getHotelNm()));
			}
		}
		return hotelVOs;
	}

	@Override
	@Transactional
	public BookingResponseVO bookRoom(BookRoom bookRoom) throws RoomsNotAvailableException {

		// List<Troom> allRoomsList =
		// bookingDAO.findAllRoomsByHotel(bookRoom.getHotel().getHotelId());
		List<TbookedRoomDetails> bookedRoomsList = bookingDAO.findBookedRoomsByHotel(bookRoom.getHotel().getHotelId(),
				bookRoom.getCheckinDate(), bookRoom.getCheckoutDate());
		Thotel hotel = bookingDAO.findHotelById(bookRoom.getHotel().getHotelId());
		int totalRooms =hotel.getNoOfRooms();
		int availableNoOfRooms = (totalRooms-getBookedNoOfRooms(bookedRoomsList));
		if (availableNoOfRooms < bookRoom.getNoOfRooms()) {
			throw new RoomsNotAvailableException(bookRoom.getNoOfRooms() + " roooms not available.");
		}

		TbookingUser tbookingUser = new TbookingUser();
		tbookingUser.setBookingDt(new Date());
		tbookingUser.setBookingRefNo("BKHOTLID" +hotel.getHotelId()+ new Date().getYear() + new Date().getMonth()+new Date().getDay());
		Double totalPrice = 0.0;
		TbookedRoomDetails tbookedRoom = new TbookedRoomDetails();
		tbookedRoom.setHotel(hotel);
		tbookedRoom.setNoOfRoomsBooked(bookRoom.getNoOfRooms());
		tbookedRoom.setCheckinDt(bookRoom.getCheckinDate());
		tbookedRoom.setCheckoutDt(bookRoom.getCheckoutDate());
		tbookedRoom.setBookingUser(tbookingUser);
		totalPrice = totalPrice + (bookRoom.getCheckoutDate().getTime() - bookRoom.getCheckinDate().getTime()) / 1000
				* 60 * 60 * 24 * bookRoom.getNoOfRooms();

		tbookingUser.setTotalPrice(totalPrice);
		tbookingUser = bookingDAO.saveBookingUserDetails(tbookingUser);

		bookingDAO.saveBookedRoomDetails(tbookedRoom);
		BookingResponseVO bookingResponseVO = new BookingResponseVO();
		bookingResponseVO.setBookingId(tbookingUser.getBookingRefNo());
		return bookingResponseVO;
	}

	private int getBookedNoOfRooms(List<TbookedRoomDetails> bookedRoomsList) {
		int noOfRoomsBooked = 0;
		for (TbookedRoomDetails room : bookedRoomsList) {
			noOfRoomsBooked = noOfRoomsBooked + room.getNoOfRoomsBooked();
		}
		return noOfRoomsBooked;
	}

	@Override
	public List<LeastPricedHotelVO> findLeastPricedHotelsByCity(CityVO cityVO) {

		List<LeastPricedHotelVO> leastPricedhotelVOs = new ArrayList<LeastPricedHotelVO>();
		List<Thotel> hotelList = bookingDAO.findLeastPricedHotelsByCity(cityVO);
		int noOfRecords= (hotelList!=null && hotelList.size()<5)?hotelList.size():5;
		for (int i=0;i<noOfRecords;i++) {
			Thotel hotel = hotelList.get(i);
			leastPricedhotelVOs.add(new LeastPricedHotelVO(hotel.getHotelId(),hotel.getHotelNm(),
					hotel.getTariff(),hotel.getLandmark(),hotel.getCity().getCityNm()));
		}
		return leastPricedhotelVOs;
	}

}
