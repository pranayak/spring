package com.project.hotel.model;

// default package
// Generated Nov 5, 2016 8:08:26 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tcity generated by hbm2java
 */
@Entity
@Table(name = "TCITY", catalog = "hotelmgmt")
public class Tcity implements java.io.Serializable {

	private int cityId;
	private String cityNm;
	private Set<Thotel> hotelSet = new HashSet<Thotel>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Thotel> getHotelSet() {
		return hotelSet;
	}

	
	public void setHotelSet(Set<Thotel> hotelSet) {
		this.hotelSet = hotelSet;
	}

	public Tcity() {
	}

	public Tcity(int cityId) {
		this.cityId = cityId;
	}

	public Tcity(int cityId, String cityNm) {
		this.cityId = cityId;
		this.cityNm = cityNm;
	}

	@Id
	@Column(name = "CITY_ID", unique = true, nullable = false)
	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Column(name = "CITY_NM", length = 50)
	public String getCityNm() {
		return this.cityNm;
	}

	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}

	
}
