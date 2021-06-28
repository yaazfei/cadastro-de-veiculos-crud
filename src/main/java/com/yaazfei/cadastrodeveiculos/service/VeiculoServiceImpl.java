package com.yaazfei.cadastrodeveiculos.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.yaazfei.cadastrodeveiculos.dto.FiltroVeiculo;
import com.yaazfei.cadastrodeveiculos.dto.StatusVenda;
import com.yaazfei.cadastrodeveiculos.dto.Total;
import com.yaazfei.cadastrodeveiculos.exception.VeiculoDuplicadoException;
import com.yaazfei.cadastrodeveiculos.exception.VeiculoNaoEncontradoException;
import com.yaazfei.cadastrodeveiculos.model.Veiculo;
import com.yaazfei.cadastrodeveiculos.repository.VeiculoRepository;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VeiculoRepository veiculoRepository;
	//Instancia do repositorio
	
	@Override
	public List<Veiculo> listarTodos() {
		return this.veiculoRepository.findAll();
	}

	@Override
	public Veiculo listarPorId(String id) {
		Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(()-> new VeiculoNaoEncontradoException("Veículo não foi encontrado"));
	//	return this.veiculoRepository.findById(id);
		return veiculo;
	}

	@Override
	public Veiculo cadastrar(Veiculo veiculo) {
		try {
			veiculo = this.veiculoRepository.save(veiculo);
			logger.info("Veículo cadastrado: {} ", veiculo);
			return veiculo;
		} catch(DuplicateKeyException ex) {
			throw new VeiculoDuplicadoException("Veiculo já cadastrado.");
		}
	}

	@Override
	public Veiculo atualizar(Veiculo veiculo) {
		veiculo.setCreated(listarPorId(veiculo.getId()).getCreated());
		return this.veiculoRepository.save(veiculo);
	}

	@Override
	public void remover(String id) {
		this.veiculoRepository.deleteById(id);

	}

	@Override
	public List<Veiculo> buscarPor(FiltroVeiculo filtroVeiculo) {
		logger.info("Buscar por: {} ", filtroVeiculo);
		return veiculoRepository.buscaPor(filtroVeiculo.getVeiculo(), filtroVeiculo.getMarca(),
				filtroVeiculo.getAno(), filtroVeiculo.getVendido());
	}

	@Override
	public Veiculo atualizarStatusVenda(String id, StatusVenda statusVenda) {
		Veiculo veiculo = listarPorId(id);
		veiculo.setVendido(statusVenda.getVendido());
		
		return atualizar(veiculo);
	}

	@Override
	public Total buscarTotalVendidos() {
		Long total = veiculoRepository.countByVendidoTrue();
		Total totalVendidos = new Total();
		totalVendidos.setTotal(total);
		logger.info("Total vendidos: {} ", totalVendidos);
		return totalVendidos;
	}

	@Override
	public List<Veiculo> buscarTotalRegistrados() {
		List<Veiculo> veiculos = veiculoRepository.findByCreatedGreaterThan(LocalDateTime.now().minusWeeks(1).with(DayOfWeek.SUNDAY));
		return veiculos;
	}
	
	

}
