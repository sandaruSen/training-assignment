package it.codegen.assignment.controller;

import it.codegen.assignment.model.Hotel;
import it.codegen.assignment.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController
{

	@Autowired
	HotelService hotelService;

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String welcome()
	{
		return "Hi Welcome !";
	}


	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Hotel> getAllHotels()
	{
		System.out.println( "Done" );
		List<Hotel> all = hotelService.getAllHotels();
		return all;
	}

	@RequestMapping(value = "/getHotel/{id}", method = RequestMethod.GET)
	public Hotel getHotel(@PathVariable int id)
	{
		Hotel hotel = hotelService.getHotel(id);
		return hotel;
	}

}
