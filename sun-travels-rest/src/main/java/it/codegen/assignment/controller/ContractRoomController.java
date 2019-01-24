package it.codegen.assignment.controller;

import it.codegen.assignment.model.ContractRoom;
import it.codegen.assignment.service.ContractRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contractRoom")
public class ContractRoomController
{
	@Autowired
	ContractRoomService contractRoomService;

	@RequestMapping(value = "/getContractRoom/{id}", method = RequestMethod.GET)
	public ContractRoom getContractRoom(@PathVariable int id)
	{
		ContractRoom contractRoom = contractRoomService.getContractRoom( id );
		return contractRoom;
	}

}
