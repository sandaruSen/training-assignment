package it.codegen.assignment.dao;


import it.codegen.assignment.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl extends AbstractDao<Integer, Room>implements RoomDao
{
	@Override
	public Room getRoom(int id){
		return getByKey( id );
	}
}
