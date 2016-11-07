/**
 * 
 */
package com.project.hotel.model.dto;

/**
 * @author prakashnayak
 *
 */
public class LeastPricedHotelVO extends HotelVO {

	private Double tariff;
	private String landmark;
	private String cityName;
	public Double getTariff() {
		return tariff;
	}
	public void setTariff(Double tariff) {
		this.tariff = tariff;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public LeastPricedHotelVO(Integer hotelId, String hotelName,Double tariff, String landmark, String cityName) {
		super(hotelId, hotelName);
		this.tariff = tariff;
		this.landmark = landmark;
		this.cityName = cityName;
	}
	
}
