package com.financial.management.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.financial.management.entities.Lancamento;

@Repository("LancamentoDAO")
public class LancamentoDAOImp extends GenericDAOImp<Lancamento, Long> implements LancamentoDAO, Serializable {

	
}
