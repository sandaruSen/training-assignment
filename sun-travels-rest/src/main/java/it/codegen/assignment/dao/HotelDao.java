package it.codegen.assignment.dao;

import it.codegen.assignment.model.Hotel;

import java.util.List;

public interface HotelDao
{
	List<Hotel> getAllHotels();
	Hotel getHotel(int id);
}
