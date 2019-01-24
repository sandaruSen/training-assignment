package it.codegen.assignment.controller;

import it.codegen.assignment.model.Contract;
import it.codegen.assignment.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
public class ContractController
{
	@Autowired
	ContractService contractService;

	@RequestMapping(value = "/getContract/{id}", method = RequestMethod.GET)
	public Contract getContract(@PathVariable int id)
	{
		Contract contract = contractService.getContract( id );
		return contract;
	}
}
