package com.financial.management.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idLancamento", nullable = false)
	private Long idLancemento;
	
	@Basic(optional = false)
	@Column(name = "dataLanc", nullable = false)
	private Date dataLanc;
	
	@Basic(optional = false)
    @Column(name = "descricao", nullable = false)
	private String descricao;
	
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "idConta", referencedColumnName = "idConta", nullable = true)  
	private Conta conta;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER) 
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria", nullable = true)  
	private Categoria categoria;
	
	@Basic(optional = false)
    @Column(name = "valor", nullable = false)
	private Double valor;

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getIdLancemento() {
		return idLancemento;
	}

	public void setIdLancemento(Long idLancemento) {
		this.idLancemento = idLancemento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getDataLanc() {
		return dataLanc;
	}

	public void setDataLanc(Date dataLanc) {
		this.dataLanc = dataLanc;
	}
	
	
	

}
