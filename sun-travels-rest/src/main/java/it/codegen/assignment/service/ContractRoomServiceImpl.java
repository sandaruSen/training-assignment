package it.codegen.assignment.service;

import it.codegen.assignment.dao.ContractRoomDao;
import it.codegen.assignment.model.ContractRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ContractRoomServiceImpl implements  ContractRoomService
{
	@Autowired
	private ContractRoomDao contractRoomDao;

	@Override
	@Transactional
	public ContractRoom getContractRoom(int id){
		return contractRoomDao.getContractRoom(id);
	}
}
