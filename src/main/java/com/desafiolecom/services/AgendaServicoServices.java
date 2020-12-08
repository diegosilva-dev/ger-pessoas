
package com.desafiolecom.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolecom.DTO.AgendaServicoDto;
import com.desafiolecom.entity.AgendaServicoEntity;
import com.desafiolecom.repository.AgendaServicoRepository;

@Service
public class AgendaServicoServices{

	@Autowired
	private AgendaServicoRepository agendaServicoRepository;

	public List<AgendaServicoEntity> listar() {
		return agendaServicoRepository.findAll();
	}

	public AgendaServicoEntity salvar(AgendaServicoDto agendaServicoDto) {

		AgendaServicoEntity agendaServico = new AgendaServicoEntity();
		
		agendaServico.setId(agendaServicoDto.getId());
		agendaServico.setCliente(agendaServicoDto.getCliente());
		agendaServico.setServico(agendaServicoDto.getServico());
		agendaServico.setTotalServico(CalculoServico(agendaServicoDto, 0));
		agendaServico.setDataInicio(agendaServicoDto.getDataInicio());
		agendaServico.setDataTermino(agendaServicoDto.getDataTermino());
		agendaServico.setDataPrevisao(agendaServicoDto.getDataPrevisao());
		return agendaServicoRepository.save(agendaServico);
	}

	public AgendaServicoEntity buscar(Long id){
		AgendaServicoEntity agendaServico = (AgendaServicoEntity)agendaServicoRepository.findAll(); 

		if (agendaServico == null) {
			throw new ServiceException("Não existe este serviço cadastrado");
		}
		return agendaServico;
	}
	
	public double CalculoServico (AgendaServicoDto agendaServicoDto, double CalculoServico){
		if(agendaServicoDto.getCliente().getTipoCliente().equals("Ouro")) {
			CalculoServico = agendaServicoDto.getServico().getValor() - (agendaServicoDto.getServico().getValor() * 0.1);
		}else if(agendaServicoDto.getCliente().getTipoCliente().equals("Prata")) {
			CalculoServico = agendaServicoDto.getServico().getValor() - (agendaServicoDto.getServico().getValor() * 0.05);
		}
		return CalculoServico;
	}

}
