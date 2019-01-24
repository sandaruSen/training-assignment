package it.codegen.assignment.service;

import it.codegen.assignment.dao.RoomDao;
import it.codegen.assignment.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RoomServiceImpl implements RoomService
{
	@Autowired
	private RoomDao roomDao;

	@Override
	@Transactional
	public Room getRoom(int id){
		return roomDao.getRoom( id );
	}
}
