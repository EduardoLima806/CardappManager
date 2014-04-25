package com.financial.management.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.financial.management.dao.ContaDAO;
import com.financial.management.entities.Conta;


@Service("ContaService")
@Transactional(propagation=Propagation.REQUIRED)
public class ContaServiceImp implements ContaService {
	
    @Resource
    ContaDAO contaDAO;
	
	@Override
	public List<Conta> getAll() {
		// TODO Auto-generated method stub
		return contaDAO.all();
	}

	@Override
	public Conta getById(Long id) {
		// TODO Auto-generated method stub
		return contaDAO.searchById(id);
	}

	@Override
	public void delete(Conta conta) throws Exception {
		// TODO Auto-generated method stub
		contaDAO.delete(conta);
	}

	@Override
	public void createNew(Conta conta) throws Exception {
		// TODO Auto-generated method stub
		contaDAO.createNew(conta);
	}

	@Override
	public void edit(Conta conta) throws Exception {
		// TODO Auto-generated method stub
		contaDAO.update(conta);
	}


	
}
