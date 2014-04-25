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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idCategoria", nullable = false)
	private Long idCategoria;
	
	@Basic(optional = false)
    @Column(name = "nome", nullable = false)
	private String nome;
	
	@Basic(optional = false)
    @Column(name = "descricao", nullable = false)
	private String descricao;
	
	
	@OneToMany(fetch = FetchType.LAZY , orphanRemoval=true, cascade=CascadeType.ALL , mappedBy = "categoria")
	private Set<Lancamento> lancamento;


	public Long getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
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


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

	
}
