package com.financial.management.dao;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.financial.management.entities.Conta;

@Repository ("ContaDAO")
public class ContaDAOImp extends GenericDAOImp<Conta, Long> implements ContaDAO, Serializable {
}
