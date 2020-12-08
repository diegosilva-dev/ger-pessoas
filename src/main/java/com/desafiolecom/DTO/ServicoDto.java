package com.desafiolecom.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class ServicoDto implements Serializable{
	
	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;
	
	private String nome;
	
	private double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
