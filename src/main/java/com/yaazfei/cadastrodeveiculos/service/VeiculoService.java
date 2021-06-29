package com.yaazfei.cadastrodeveiculos.service;

import java.util.List;

import com.yaazfei.cadastrodeveiculos.dto.AnoTotal;
import com.yaazfei.cadastrodeveiculos.dto.DecadaTotal;
import com.yaazfei.cadastrodeveiculos.dto.FiltroVeiculo;
import com.yaazfei.cadastrodeveiculos.dto.MarcaTotal;
import com.yaazfei.cadastrodeveiculos.dto.StatusVenda;
import com.yaazfei.cadastrodeveiculos.dto.Total;
import com.yaazfei.cadastrodeveiculos.model.Veiculo;

public interface VeiculoService {

	List<Veiculo> listarTodos();
	
	Veiculo listarPorId(String id);
	
	Veiculo cadastrar(Veiculo veiculo);
	
	Veiculo atualizar(Veiculo veiculo);
	
	List<Veiculo> buscarPor(FiltroVeiculo filtroVeiculo);

	Veiculo atualizarStatusVenda (String id, StatusVenda statusVenda);
	
	void remover(String id);

	Total buscarTotalVendidos();

	List<Veiculo> buscarTotalRegistrados();
	
	List<MarcaTotal> buscarTotalPorMarca();

	
	List<DecadaTotal> buscarTotalPorDecada();
	
}
