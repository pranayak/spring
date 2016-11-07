/**
 * 
 */
package com.project.hotel.web;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.project.hotel.model.dto.CityVO;
import com.project.hotel.model.dto.HotelVO;

/**
 * @author prakashnayak
 * 
 */
public class BookRoom {

	@NotEmpty(message = "checkindate.error.Required")
	private Date checkinDate;
	@NotEmpty(message = "checkoutdate.error.Required")
	private Date checkoutDate;
	@NotEmpty(message = "noofrooms.error.Required")
	private Integer noOfRooms;

	private Double tariff;
	private CityVO city;
	private HotelVO hotel;

	public BookRoom() {
		this.city = new CityVO();
		this.hotel = new HotelVO();
	}

	public BookRoom(Date checkinDate, Date checkoutDate, Integer noOfRooms,
			CityVO city, HotelVO hotel) {
		super();
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.noOfRooms = noOfRooms;
		this.city = city;
		this.hotel = hotel;
	}

	/**
	 * @return the checkinDate
	 */
	public Date getCheckinDate() {
		return checkinDate;
	}

	/**
	 * @param checkinDate
	 *            the checkinDate to set
	 */
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	/**
	 * @return the checkoutDate
	 */
	public Date getCheckoutDate() {
		return checkoutDate;
	}

	/**
	 * @param checkoutDate
	 *            the checkoutDate to set
	 */
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	/**
	 * @return the noOfRooms
	 */
	public Integer getNoOfRooms() {
		return noOfRooms;
	}

	/**
	 * @param noOfRooms
	 *            the noOfRooms to set
	 */
	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	/**
	 * @return the city
	 */
	public CityVO getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(CityVO city) {
		this.city = city;
	}

	/**
	 * @return the hotel
	 */
	public HotelVO getHotel() {
		return hotel;
	}

	/**
	 * @param hotel
	 *            the hotel to set
	 */
	public void setHotel(HotelVO hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the tariff
	 */
	public Double getTariff() {
		return tariff;
	}

	/**
	 * @param tariff
	 *            the tariff to set
	 */
	public void setTariff(Double tariff) {
		this.tariff = tariff;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoomVO [checkinDate=");
		builder.append(checkinDate);
		builder.append(", checkoutDate=");
		builder.append(checkoutDate);
		builder.append(", noOfRooms=");
		builder.append(noOfRooms);
		builder.append(", tariff=");
		builder.append(tariff);
		builder.append(", city=");
		builder.append(city);
		builder.append(", hotel=");
		builder.append(hotel);
		builder.append("]");
		return builder.toString();
	}

}
