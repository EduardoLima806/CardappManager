package com.financial.management.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.financial.management.dao.CategoriaDAO;
import com.financial.management.entities.Categoria;


@Service("CategoriaService")
@Transactional(propagation=Propagation.REQUIRED)
public class CategoriaServiceImp implements CategoriaService{
	
	@Resource
	CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return categoriaDAO.all();
	}

	@Override
	public void delete(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		categoriaDAO.delete(categoria);	
	}

	@Override
	public void createNew(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		categoriaDAO.createNew(categoria);
	}

	@Override
	public void edit(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		categoriaDAO.update(categoria);
	}

	@Override
	public Categoria getById(Long id) {
		// TODO Auto-generated method stub
		return categoriaDAO.searchById(id);
	}
	
    
}
