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

import com.desafiolecom.entity.ServicoEntity;
import com.desafiolecom.repository.ServicoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "servico")
@RequestMapping("/api/servico")
public class ServicoController {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@ApiOperation(value = "Consulta todos os registros")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<ServicoEntity> Get() {
        return servicoRepository.findAll();
    }

	@ApiOperation(value = "Consulta registro por id")
    @RequestMapping(value = "/search/{id_servico}", method = RequestMethod.GET)
    public ResponseEntity<ServicoEntity> GetById(@PathVariable(value = "id_servico") Long id)
    {
        Optional<ServicoEntity> servico = servicoRepository.findById(id);
        if(servico.isPresent())
            return new ResponseEntity<ServicoEntity>(servico.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @ApiOperation(value = "Insere novo registro")
    @RequestMapping(value = "/new", method =  RequestMethod.POST)
    public ServicoEntity Post(@Validated @RequestBody ServicoEntity servico)
    {
        return servicoRepository.save(servico);
    }

    @ApiOperation(value = "Atualiza registro")
    @RequestMapping(value = "/update/{id_servico}", method =  RequestMethod.PUT)
    public ResponseEntity<ServicoEntity> Put(@PathVariable(value = "id_servico") Long id, @Validated @RequestBody ServicoEntity newServico)
    {
        Optional<ServicoEntity> oldServico = servicoRepository.findById(id);
        if(oldServico.isPresent()){
        	ServicoEntity servico = oldServico.get();
        	servico.setNome(newServico.getNome());
        	servico.setValor(newServico.getValor());
        	servicoRepository.save(servico);
            return new ResponseEntity<ServicoEntity>(servico, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Deleta registro por id")
    @RequestMapping(value = "/delete/{id_servico}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id_servico") Long id)
    {
        Optional<ServicoEntity> servico = servicoRepository.findById(id);
        if(servico.isPresent()){
        	servicoRepository.delete(servico.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
