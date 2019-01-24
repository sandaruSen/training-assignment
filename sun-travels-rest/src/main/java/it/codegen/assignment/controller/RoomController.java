package it.codegen.assignment.controller;

import it.codegen.assignment.model.Room;
import it.codegen.assignment.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController
{

	@Autowired
	RoomService roomService;

	@RequestMapping(value = "/getRoom/{id}", method = RequestMethod.GET)
	public Room getRoom(@PathVariable int id)
	{
		Room room = roomService.getRoom(id);
		return room;
	}
}
