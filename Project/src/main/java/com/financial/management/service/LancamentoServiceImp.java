package com.financial.management.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.financial.management.dao.LancamentoDAO;
import com.financial.management.entities.Lancamento;

@Service("LancamentoService")
@Transactional(propagation=Propagation.REQUIRED)
public class LancamentoServiceImp implements LancamentoService{
	
	@Resource
	LancamentoDAO lancamentoDAO;

	@Override
	public List<Lancamento> getAll() {
		// TODO Auto-generated method stub
		return lancamentoDAO.all();
	}

	@Override
	public void delete(Lancamento lancamento) throws Exception {
		// TODO Auto-generated method stub
		lancamentoDAO.delete(lancamento);
	}

	@Override
	public void createNew(Lancamento lancamento) throws Exception {
		// TODO Auto-generated method stub
		lancamentoDAO.createNew(lancamento);
	}

	@Override
	public void edit(Lancamento lancamento) throws Exception {
		// TODO Auto-generated method stub
		lancamentoDAO.update(lancamento);
		
	}

	@Override
	public void delete(String property, Long id) throws Exception {
		// TODO Auto-generated method stub
		lancamentoDAO.delete(property, id);
	}

	public Lancamento getById(long l) {
		// TODO Auto-generated method stub
		return lancamentoDAO.searchById(l);
	}
	

}
