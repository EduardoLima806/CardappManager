package com.financial.management.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.financial.management.entities.Categoria;

@Repository("CategoriaDAO")
public class CategoriaDAOImp  extends GenericDAOImp<Categoria, Long> implements CategoriaDAO, Serializable {
}