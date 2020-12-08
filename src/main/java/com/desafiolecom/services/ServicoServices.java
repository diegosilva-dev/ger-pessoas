package com.desafiolecom.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolecom.DTO.ServicoDto;
import com.desafiolecom.entity.ServicoEntity;
import com.desafiolecom.repository.ServicoRepository;

@Service
public class ServicoServices {
	
	@Autowired
	private ServicoRepository servicoRepository;

	public List<ServicoEntity> listar() {
		return servicoRepository.findAll();
	}

	public ServicoEntity salvar(ServicoDto servicoDto) {

		ServicoEntity servico = new ServicoEntity();
		
		servico.setId(servicoDto.getId());
		servico.setNome(servicoDto.getNome());
		servico.setValor(servicoDto.getValor());
		return servicoRepository.save(servico);
	}

	public ServicoEntity buscar(Long id){
		ServicoEntity servico = (ServicoEntity)servicoRepository.findAll(); 

		if (servico == null) {
			throw new ServiceException("Não existe este serviço cadastrado");
		}
		return servico;
	}

}
