package it.codegen.assignment.service;

import it.codegen.assignment.model.Hotel;

import java.util.List;

public interface HotelService
{
	List<Hotel> getAllHotels();

	Hotel getHotel(int id);
}
