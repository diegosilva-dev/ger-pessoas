package com.desafiolecom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipocliente")
public class TipoClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipocliente")
	private Long id;

	@Column(name = "tipocliente")
	private String tipoCliente;
	
	@Column(name = "valordesconto")
	private Integer valorDesconto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Integer getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Integer valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
				
}
