package com.project.hotel.model.dto;

public class HotelVO {

	private Integer hotelId;
	private String hotelName;
	
	public HotelVO() {
		// TODO Auto-generated constructor stub
	}
	
	public HotelVO(Integer hotelId, String hotelName) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
	}
	/**
	 * @return the hotelId
	 */
	public Integer getHotelId() {
		return hotelId;
	}
	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}
	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
}
