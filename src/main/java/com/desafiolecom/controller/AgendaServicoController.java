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

import com.desafiolecom.entity.AgendaServicoEntity;
import com.desafiolecom.repository.AgendaServicoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "servico")
@RequestMapping("/api/agendaservico")
public class AgendaServicoController {

	@Autowired
	private AgendaServicoRepository agendaServicoRepository;
	
	@ApiOperation(value = "Consulta todos os registros")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<AgendaServicoEntity> Get() {
        return agendaServicoRepository.findAll();
    }
	
	@ApiOperation(value = "Consulta registo por id")
    @RequestMapping(value = "/search/{id_agendaservico}", method = RequestMethod.GET)
    public ResponseEntity<AgendaServicoEntity> GetById(@PathVariable(value = "id_agendaservico") Long id)
    {
        Optional<AgendaServicoEntity> servico = agendaServicoRepository.findById(id);
        if(servico.isPresent())
            return new ResponseEntity<AgendaServicoEntity>(servico.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @ApiOperation(value = "Insere novo registro")
    @RequestMapping(value = "/new", method =  RequestMethod.POST)
    public AgendaServicoEntity Post(@Validated @RequestBody AgendaServicoEntity servico)
    {
        return agendaServicoRepository.save(servico);
    }

    @ApiOperation(value = "Atualiza registro")
    @RequestMapping(value = "/update/{id_agendaservico}", method =  RequestMethod.PUT)
    public ResponseEntity<AgendaServicoEntity> Put(@PathVariable(value = "id_agendaservico") Long id, @Validated @RequestBody AgendaServicoEntity newAgendaServico)
    {
        Optional<AgendaServicoEntity> oldAgendaServico = agendaServicoRepository.findById(id);
        if(oldAgendaServico.isPresent()){
        	AgendaServicoEntity agendaServico = oldAgendaServico.get();
        	agendaServico.setCliente(newAgendaServico.getCliente());
        	agendaServico.setDataInicio(newAgendaServico.getDataInicio());
        	agendaServico.setDataTermino(newAgendaServico.getDataTermino());
        	agendaServico.setDataPrevisao(newAgendaServico.getDataPrevisao());
        	agendaServico.setServico(newAgendaServico.getServico());
        	agendaServicoRepository.save(agendaServico);
            return new ResponseEntity<AgendaServicoEntity>(agendaServico, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Deleta registro por id")
    @RequestMapping(value = "/delete/{id_agendaservico}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id_agendaservico") Long id)
    {
        Optional<AgendaServicoEntity> servico = agendaServicoRepository.findById(id);
        if(servico.isPresent()){
        	agendaServicoRepository.delete(servico.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
