package it.codegen.assignment.dao;

import it.codegen.assignment.model.Hotel;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDaoImpl extends AbstractDao<Integer, Hotel> implements HotelDao {

	public List<Hotel> getAllHotels()
	{
		Criteria criteria = createEntityCriteria();
		return ( List<Hotel> ) criteria.list();
	}
	public Hotel getHotel(int id){

		return getByKey( id );
	}

}
