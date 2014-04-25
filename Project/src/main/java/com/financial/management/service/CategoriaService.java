package com.financial.management.service;

import java.util.List;

import com.financial.management.entities.Categoria;

public interface CategoriaService {
	
    public List<Categoria> getAll();
    
    public Categoria  getById(Long id);

	public void delete(Categoria categoria) throws Exception;
	
	public void createNew(Categoria categoria) throws Exception;

	public void edit(Categoria categoria) throws Exception;
	
}
