
/**
 * 
 */
package com.project.hotel.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.hotel.model.TbookedRoomDetails;
import com.project.hotel.model.TbookingUser;
import com.project.hotel.model.Tcity;
import com.project.hotel.model.Thotel;
import com.project.hotel.model.dto.CityVO;

/**
 * @author pnayak
 *
 */
@Repository
public class BookingDAOImpl extends HibernateDaoSupport implements IBookingDAO{
	

	
	@Override
	@Transactional(readOnly=true)
	public List<Tcity> findAllCities() {
		List cityList = getHibernateTemplate().find("from Tcity");
        return  cityList;
	}

	@Override
	public List<Thotel> findHotelsByCity(Integer cityId) {
		List hotelList = getHibernateTemplate().find("from Thotel where city.cityId=? ",cityId);
        return  hotelList;
	}

	@Override
	public List<Thotel> findLeastPricedHotelsByCity(CityVO cityVO) {
		List<Thotel> hotelList = (List<Thotel>) getHibernateTemplate().find("from Thotel  where city.cityId=? order by tariff asc)",cityVO.cityId);
		for (Thotel hotel : hotelList) {
		    Hibernate.initialize(hotel.getCity());
		}
        return  hotelList;
	}

	@Override
	public Thotel findHotelById(Integer hoteld) {
		List<Thotel> hotelList = (List<Thotel>) getHibernateTemplate().find("from Thotel  where hotelId=?)",hoteld);
		if(hotelList.size()>0)
			return hotelList.get(0);
        return  null;
	}

	@Override
	public List<TbookedRoomDetails> findBookedRoomsByHotel(Integer hotelId,Date checkinDate,Date checkoutDate) {
		List<TbookedRoomDetails> roomList = (List<TbookedRoomDetails>) getHibernateTemplate().find("from TbookedRoomDetails where hotel.hotelId=? and ((?<=checkinDt and ?>=checkinDt) or (?<checkoutDt and ?>=checkoutDt)))",hotelId,checkinDate,checkoutDate,checkinDate,checkoutDate);
        return  roomList;
	}

	@Override
	public TbookingUser saveBookingUserDetails(TbookingUser bookingUser) {
		 getHibernateTemplate().save(bookingUser);
		 
		return bookingUser;
	}
	
	@Override
	public void saveBookedRoomDetails(TbookedRoomDetails bookedRoom) {
		 getHibernateTemplate().save(bookedRoom);
		
	}

}
