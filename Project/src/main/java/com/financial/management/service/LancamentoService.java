package com.financial.management.service;

import java.util.List;

import com.financial.management.entities.Lancamento;

public interface LancamentoService{
	
	    public Lancamento getById(long l);
	    
	    public List<Lancamento> getAll();

		public void delete(Lancamento lancamento) throws Exception;
		
		public void delete(String property, Long id) throws Exception;
		
		public void createNew(Lancamento lancamento) throws Exception;

		public void edit(Lancamento lancamento) throws Exception;
}
