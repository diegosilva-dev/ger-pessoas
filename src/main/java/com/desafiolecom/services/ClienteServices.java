package com.desafiolecom.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolecom.DTO.ClienteDto;
import com.desafiolecom.entity.ClienteEntity;
import com.desafiolecom.repository.ClienteRepository;

@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteEntity> listar() {
		return clienteRepository.findAll();
	}

	public ClienteEntity salvar(ClienteDto clienteDto) {

		ClienteEntity cliente = new ClienteEntity();
		
		cliente.setId(clienteDto.getId());
		cliente.setNome(clienteDto.getNome());
		cliente.setCpf(clienteDto.getCpf());
		cliente.setTelefone(clienteDto.getTelefone());
		cliente.setTipoCliente(clienteDto.getTipocliente());
		return clienteRepository.save(cliente);
	}

	public ClienteEntity buscar(Long id){
		ClienteEntity cliente = (ClienteEntity)clienteRepository.findAll(); 

		if (cliente == null) {
			throw new ServiceException("Não existe este cliente cadastrado");
		}
		return cliente;
	}
}
