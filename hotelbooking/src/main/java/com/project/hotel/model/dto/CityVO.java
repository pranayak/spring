/**
 * 
 */
package com.project.hotel.model.dto;

/**
 * @author pnayak
 *
 */
public class CityVO {

	public Integer cityId;
	public String cityName;
	
	public CityVO() {
		// TODO Auto-generated constructor stub
	}
	
	public CityVO(Integer cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}
	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
