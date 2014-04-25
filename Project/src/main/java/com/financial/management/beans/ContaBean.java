package com.financial.management.beans;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ViewScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.financial.management.entities.Conta;
import com.financial.management.service.ContaService;


@Controller("contaBean")
@ViewScoped
public class ContaBean {
	
	private Conta conta;
	
	@Resource
	private ContaService contaservice;
	private double valorDeposito;
	
	@PostConstruct
	public void getInit() {
		// TODO Auto-generated constructor stub
        conta = contaservice.getById((long)1);
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public void atualizaSaldo() throws Exception{
		
		conta.setSaldo(conta.getSaldo()+valorDeposito);
		contaservice.edit(conta);
		
	}

	public double getValorDeposito() {
		return valorDeposito;
	}

	public void setValorDeposito(double valorDeposito) {
		this.valorDeposito = valorDeposito;
	}
	
	

}
