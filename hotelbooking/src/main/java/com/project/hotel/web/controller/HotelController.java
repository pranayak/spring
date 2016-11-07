/**
 * 
 */
package com.project.hotel.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.hotel.exception.DataNotFoundException;
import com.project.hotel.exception.RoomsNotAvailableException;
import com.project.hotel.model.dto.BookingResponseVO;
import com.project.hotel.model.dto.CityVO;
import com.project.hotel.model.dto.HotelVO;
import com.project.hotel.model.dto.LeastPricedHotelVO;
import com.project.hotel.service.IBookingService;
import com.project.hotel.web.BookRoom;

/**
 * @author pnayak
 * 
 */
@Controller
public class HotelController {

	@Autowired
	private IBookingService bookingService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/viewbookroom", method = RequestMethod.GET)
	public String bookRoom(Model model) {
		List<CityVO> cityList = null;
		try {
			cityList = bookingService.findAllCities();
		} catch (DataNotFoundException e) {
			model.addAttribute("errMessage", e.getMessage());
		}
		model.addAttribute("allCities", cityList);
		model.addAttribute("command", new BookRoom());
		return "roombook";
	}

	@RequestMapping(value = "/viewLeastPricedHotels", method = RequestMethod.GET)
	public String viewLeastPricedHotels(Model model) {

		List<CityVO> cityList = null;
		try {
			cityList = bookingService.findAllCities();
		} catch (DataNotFoundException e) {
			model.addAttribute("errMessage", e.getMessage());
		}
		model.addAttribute("allCities", cityList);
		model.addAttribute("command", new BookRoom());
		return "viewLeastPricedHotels";
	}

	@RequestMapping(value = "/getHotelsForCity", method = RequestMethod.GET)
	public @ResponseBody List<HotelVO> getHotelsForCity(@RequestParam(name = "cityId") Integer id) {

		List<HotelVO> hotelList = null;
		try {
			hotelList = bookingService.findHotelsByCity(id);
		} catch (DataNotFoundException e) {
		}
		return hotelList;
	}

	@RequestMapping(value = "/bookroom", method = RequestMethod.POST)
	public String bookRoom(BookRoom bookRoom, Model model, BindingResult binding) {
		if (binding.hasErrors()) {
			return "";
		}
		try {
			BookingResponseVO bookingResponseVO = bookingService.bookRoom(bookRoom);
			model.addAttribute("message", "Hotel is booked successfully. Booking Id : " + bookingResponseVO.getBookingId());
		} catch (RoomsNotAvailableException e) {
			model.addAttribute("errMessage", e.getMessage());
		}
		
		return "successbooking";
	}

	@RequestMapping(value = "/viewHotels", method = RequestMethod.POST)
	public String viewHotels(BookRoom roomVO, Model model, BindingResult binding) {

		List<LeastPricedHotelVO> hotelList = bookingService.findLeastPricedHotelsByCity(roomVO.getCity());
		model.addAttribute("hotels", hotelList);
		model.addAttribute("command", roomVO);

		List<CityVO> cityList = null;
		try {
			cityList = bookingService.findAllCities();
		} catch (DataNotFoundException e) {
			model.addAttribute("errMessage", e.getMessage());
		}
		model.addAttribute("allCities", cityList);
		return "viewLeastPricedHotels";
	}

}
