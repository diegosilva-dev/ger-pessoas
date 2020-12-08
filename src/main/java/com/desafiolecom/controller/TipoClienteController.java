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

import com.desafiolecom.entity.TipoClienteEntity;
import com.desafiolecom.repository.TipoClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "tipocliente")
@RequestMapping("/api/tipocliente")
public class TipoClienteController {

	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	@ApiOperation(value = "Consulta todos os registros")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<TipoClienteEntity> Get() {
        return tipoClienteRepository.findAll();
    }

	@ApiOperation(value = "Consulta registro por id")
    @RequestMapping(value = "/search/{id_tipocliente}", method = RequestMethod.GET)
    public ResponseEntity<TipoClienteEntity> GetById(@PathVariable(value = "id_tipocliente") Long id)
    {
        Optional<TipoClienteEntity> tipoCliente = tipoClienteRepository.findById(id);
        if(tipoCliente.isPresent())
            return new ResponseEntity<TipoClienteEntity>(tipoCliente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @ApiOperation(value = "Insere novo registro")
    @RequestMapping(value = "/new", method =  RequestMethod.POST)
    public TipoClienteEntity Post(@Validated @RequestBody TipoClienteEntity tipoCliente)
    {
        return tipoClienteRepository.save(tipoCliente);
    }

    @ApiOperation(value = "Atualiza registro")
    @RequestMapping(value = "/update/{id_tipocliente}", method =  RequestMethod.PUT)
    public ResponseEntity<TipoClienteEntity> Put(@PathVariable(value = "id_tipocliente") Long id, @Validated @RequestBody TipoClienteEntity newTipoCliente)
    {
        Optional<TipoClienteEntity> oldTipoCliente = tipoClienteRepository.findById(id);
        if(oldTipoCliente.isPresent()){
        	TipoClienteEntity tipoCliente = oldTipoCliente.get();
        	tipoCliente.setTipoCliente(newTipoCliente.getTipoCliente());
        	tipoCliente.setValorDesconto(newTipoCliente.getValorDesconto());
        	tipoClienteRepository.save(tipoCliente);
            return new ResponseEntity<TipoClienteEntity>(tipoCliente, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Deleta registro por id")
    @RequestMapping(value = "/delete/{id_tipocliente}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id_tipocliente") Long id)
    {
        Optional<TipoClienteEntity> tipoCliente = tipoClienteRepository.findById(id);
        if(tipoCliente.isPresent()){
        	tipoClienteRepository.delete(tipoCliente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
