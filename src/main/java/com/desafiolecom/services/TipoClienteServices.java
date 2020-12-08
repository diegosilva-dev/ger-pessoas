package com.desafiolecom.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolecom.DTO.TipoClienteDto;
import com.desafiolecom.entity.TipoClienteEntity;
import com.desafiolecom.repository.TipoClienteRepository;

@Service
public class TipoClienteServices {

	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	public List<TipoClienteEntity> listar() {
		return tipoClienteRepository.findAll();
	}

	public TipoClienteEntity salvar(TipoClienteDto tipoClienteDto) {
		TipoClienteEntity tipoCliente = new TipoClienteEntity();

		tipoCliente.setId(tipoClienteDto.getId());
		tipoCliente.setTipoCliente(tipoClienteDto.getTipoCliente());
		tipoCliente.setValorDesconto(tipoClienteDto.getValorDesconto());
		return tipoClienteRepository.save(tipoCliente);
	}

	public TipoClienteEntity buscar(Long id) {
		TipoClienteEntity tipoCliente = (TipoClienteEntity) tipoClienteRepository.findAll();
		
		if (tipoCliente == null) {
			throw new ServiceException("Não existe este tipo de cliente cadastrado");
		}
		return tipoCliente;
	}
}
