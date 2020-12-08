package com.desafiolecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafiolecom.entity.ClienteEntity;
import com.desafiolecom.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Cliente")
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@ApiOperation(value = "Consulta todos os registros")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<ClienteEntity> Get() {
        return clienteRepository.findAll();
    }

	@ApiOperation(value = "Consulta registro por id")
    @RequestMapping(value = "/search/{id_cliente}", method = RequestMethod.GET)
    public ResponseEntity<ClienteEntity> GetById(@PathVariable(value = "id_cliente") Long id)
    {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        if(cliente.isPresent())
            return new ResponseEntity<ClienteEntity>(cliente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @ApiOperation(value = "Insere novo registro")
    @RequestMapping(value = "/new", method =  RequestMethod.POST)
    public ClienteEntity Post(@Validated @RequestBody ClienteEntity cliente)
    {
        return clienteRepository.save(cliente);
    }

    @ApiOperation(value = "Atualiza registro")
    @RequestMapping(value = "/update/{id_cliente}", method =  RequestMethod.PUT)
    public ResponseEntity<ClienteEntity> Put(@PathVariable(value = "id_cliente") Long id, @Validated @RequestBody ClienteEntity newCliente)
    {
        Optional<ClienteEntity> oldCliente = clienteRepository.findById(id);
        if(oldCliente.isPresent()){
        	ClienteEntity cliente = oldCliente.get();
        	cliente.setNome(newCliente.getNome());
        	cliente.setCpf(newCliente.getCpf());
        	cliente.setTelefone(newCliente.getTelefone());
        	cliente.setTipoCliente(newCliente.getTipoCliente());
            clienteRepository.save(cliente);
            return new ResponseEntity<ClienteEntity>(cliente, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Deleta registro por id")
    @RequestMapping(value = "/delete/{id_cliente}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id_cliente") Long id)
    {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
        	clienteRepository.delete(cliente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
