package com.desafiolecom.DTO;

import java.io.Serializable;

public class TipoClienteDto implements Serializable{

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;
	
	private String tipoCliente;
	
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
