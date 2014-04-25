package com.financial.management.service;

import java.util.List;

import com.financial.management.entities.Conta;


public interface ContaService {
	
	    public List<Conta> getAll();
	    
	    public Conta  getById(Long id);

		public void delete(Conta conta) throws Exception;
		
		public void createNew(Conta conta) throws Exception;

		public void edit(Conta conta) throws Exception;
}
