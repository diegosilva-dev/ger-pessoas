package com.desafiolecom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_cliente")
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_cliente")
	private Long id;
	
	@Column(name="nome")
	private String nome;

	@Column(name="cpf")
	private String cpf;
	
	@Column(name="telefone")
	private String telefone;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipocliente", referencedColumnName = "id_tipocliente")
	private TipoClienteEntity tipoCliente;
	
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

	public TipoClienteEntity getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoClienteEntity tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
}
