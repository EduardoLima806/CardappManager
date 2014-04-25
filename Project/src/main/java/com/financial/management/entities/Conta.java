package com.financial.management.entities;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conta")
public class Conta {
  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idConta", nullable = false)
	private Long idConta;
	
	@Basic(optional = false)
    @Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Basic(optional = false)
    @Column(name = "saldo", nullable = false)
	private double saldo;
	
	
	@OneToMany(fetch = FetchType.LAZY , orphanRemoval=true, cascade=CascadeType.ALL , mappedBy = "conta")
	private Set<Lancamento> lancamento;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)  
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = true)  
	private User user;


	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Lancamento> getLancamento() {
		return lancamento;
	}

	public void setLancamento(Set<Lancamento> lancamento) {
		this.lancamento = lancamento;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	} 
	
}
