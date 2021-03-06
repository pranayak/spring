package com.project.hotel.model;

// default package
// Generated Nov 5, 2016 8:08:26 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Thotel generated by hbm2java
 */
@Entity
@Table(name = "THOTEL", catalog = "hotelmgmt")
public class Thotel implements java.io.Serializable {

	private Integer hotelId;
	private String hotelNm;
	private String landmark;
	private Integer noOfRooms;
	private Integer rating;
	private Double tariff;
	private Tcity city;

	public Thotel() {
	}

	public Thotel(int hotelId, String hotelNm) {
		this.hotelId = hotelId;
		this.hotelNm = hotelNm;
	}

	@Id
	@Column(name = "HOTEL_ID", unique = true, nullable = false)
	public int getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	@Column(name = "HOTEL_NM", length = 50)
	public String getHotelNm() {
		return this.hotelNm;
	}

	public void setHotelNm(String hotelNm) {
		this.hotelNm = hotelNm;
	}
	
	@Column(name = "LANDMARK", length = 50)
	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITY_ID", nullable = false)
	public Tcity getCity() {
		return city;
	}

	public void setCity(Tcity city) {
		this.city = city;
	}

	/**
	 * @return the noOfRooms
	 */
	@Column(name = "NO_OF_ROOMS", length = 50)
	public Integer getNoOfRooms() {
		return noOfRooms;
	}

	/**
	 * @param noOfRooms the noOfRooms to set
	 */
	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	/**
	 * @return the rating
	 */
	@Column(name = "RATING", length = 50)
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * @return the tariff
	 */
	@Column(name = "TARIFF", length = 50)
	public Double getTariff() {
		return tariff;
	}

	/**
	 * @param tariff the tariff to set
	 */
	public void setTariff(Double tariff) {
		this.tariff = tariff;
	}

	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	

}
