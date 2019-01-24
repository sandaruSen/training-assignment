package it.codegen.assignment.service;

import it.codegen.assignment.dao.HotelDao;
import it.codegen.assignment.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HotelServiceImpl implements HotelService
{
	@Autowired
	private HotelDao hotelDao;

	@Override
	@Transactional
	public List<Hotel> getAllHotels()
	{
		return hotelDao.getAllHotels();
	}

	@Override
	public Hotel getHotel(int id){
		return hotelDao.getHotel(id);
	}




}
