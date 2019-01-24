package it.codegen.assignment.service;

import it.codegen.assignment.dao.ContractDao;
import it.codegen.assignment.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ContractServiceImpl implements ContractService
{
	@Autowired
	private ContractDao contractDao;

	@Override
	@Transactional
	public Contract getContract(int id){
		return contractDao.getContract(id);
	}

}
