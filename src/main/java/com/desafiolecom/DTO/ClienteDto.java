package com.desafiolecom.DTO;

import java.io.Serializable;

import com.desafiolecom.entity.TipoClienteEntity;

public class ClienteDto extends TipoClienteEntity implements Serializable{

	private static final long serialVersionUID = -8105241933692707649L;
	
	public Long id;
	
	private String nome;
	
	private String cpf;
	
	private String telefone;
	
	private TipoClienteEntity tipocliente;
	
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
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoClienteEntity getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(TipoClienteEntity tipocliente) {
		this.tipocliente = tipocliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
