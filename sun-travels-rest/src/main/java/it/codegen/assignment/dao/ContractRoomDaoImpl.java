package it.codegen.assignment.dao;

import it.codegen.assignment.model.ContractRoom;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRoomDaoImpl extends AbstractDao<Integer, ContractRoom> implements ContractRoomDao
{
	public ContractRoom getContractRoom(int id){
		return getByKey( id );
	}
}
