package com.yaazfei.cadastrodeveiculos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yaazfei.cadastrodeveiculos.dto.FiltroVeiculo;
import com.yaazfei.cadastrodeveiculos.dto.StatusVenda;
import com.yaazfei.cadastrodeveiculos.dto.Total;
import com.yaazfei.cadastrodeveiculos.model.Veiculo;
import com.yaazfei.cadastrodeveiculos.service.VeiculoService;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private VeiculoService veiculoService;
	
	public VeiculoController (VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> listarTodos(){
		return ResponseEntity.ok(this.veiculoService.listarTodos());
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<Veiculo>> buscarPor(@RequestParam(value = "veiculo", required = false) String veiculo,
			@RequestParam(value = "marca", required = false) String marca,
			@RequestParam(value = "ano", required = false) Integer ano,
			@RequestParam(value = "vendido", required = false) Boolean vendido){
		return ResponseEntity.ok(this.veiculoService.buscarPor(new FiltroVeiculo(veiculo, marca, ano, vendido)));
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Veiculo> listarPorId(@PathVariable (name = "id") String id){
		return ResponseEntity.ok(this.veiculoService.listarPorId(id));
	}
	
	@GetMapping ("/vendidos")
	public ResponseEntity<Total> buscarTotalVendidos(){
		return ResponseEntity.ok(this.veiculoService.buscarTotalVendidos());
	}
	
	@GetMapping ("/registrados")
	public ResponseEntity<List<Veiculo>> buscarTotalRegistrados(){
		return ResponseEntity.ok(this.veiculoService.buscarTotalRegistrados());
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> cadastrar(@Valid @RequestBody Veiculo veiculo){
		logger.info("Cadastrando veículo: {} ", veiculo);
		return ResponseEntity.ok(this.veiculoService.cadastrar(veiculo));
	}
	
	@PutMapping(path =  "/{id}")
	public ResponseEntity <Veiculo> atualizar(@PathVariable(name = "id") String id,
			@Valid @RequestBody Veiculo veiculo){
		veiculo.setId(id);
		return ResponseEntity.ok(this.veiculoService.atualizar(veiculo));
	}
	
	@PatchMapping(path =  "/{id}")
	public ResponseEntity <Veiculo> atualizarStatusVenda(@PathVariable(name = "id") String id,
			@Valid @RequestBody StatusVenda statusVenda){
		
		return ResponseEntity.ok(this.veiculoService.atualizarStatusVenda(id, statusVenda));
	}	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> remover(@PathVariable(name = "id") String id){
		this.veiculoService.remover(id);
		return ResponseEntity.ok(1);	
	}
	
	
}
