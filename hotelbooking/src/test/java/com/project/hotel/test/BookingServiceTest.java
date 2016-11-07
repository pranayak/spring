/**
 * 
 */
package com.project.hotel.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.project.hotel.ApplicationConfig;
import com.project.hotel.exception.DataNotFoundException;
import com.project.hotel.model.dto.CityVO;
import com.project.hotel.service.IBookingService;

/**
 * @author prakashnayak
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class,loader = AnnotationConfigContextLoader.class)
public class BookingServiceTest {

	@Autowired
	private IBookingService bookingService;
	
	@Test
	public void testFindAllCities()
	{
		List<CityVO> cities = null;
		try {
			cities = bookingService.findAllCities();
		} catch (DataNotFoundException e) {
			fail("Fetching All Cities failed");
		}		
		assertTrue("Cities fetched successfully", cities.size()>0);
	}
	
}
