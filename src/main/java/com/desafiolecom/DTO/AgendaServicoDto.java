package com.desafiolecom.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import com.desafiolecom.entity.ClienteEntity;
import com.desafiolecom.entity.ServicoEntity;

public class AgendaServicoDto implements Serializable{
	
	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;
	
	private ClienteEntity cliente;
	
	private ServicoEntity servico;
	
	private double totalServico;
	
	private Date dataInicio;
	
	private Date dataTermino;
	
	private Date dataPrevisao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	
	public ServicoEntity getServico() {
		return servico;
	}

	public void setServico(ServicoEntity servico) {
		this.servico = servico;
	}
	
	public double getTotalServico() {
		return totalServico;
	}

	public void setTotalServico(double totalServico) {
		this.totalServico = totalServico;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Date getDataPrevisao() {
		return dataPrevisao;
	}

	public void setDataPrevisao(Date dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}
		
}
