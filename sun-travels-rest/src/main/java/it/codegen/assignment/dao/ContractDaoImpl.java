package it.codegen.assignment.dao;

import it.codegen.assignment.model.Contract;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDaoImpl extends AbstractDao<Integer, Contract> implements ContractDao
{
	public Contract getContract(int id){
		return getByKey( id );
	}

}
