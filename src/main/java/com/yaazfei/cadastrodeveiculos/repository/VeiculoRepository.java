package com.yaazfei.cadastrodeveiculos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.yaazfei.cadastrodeveiculos.dto.AnoTotal;
import com.yaazfei.cadastrodeveiculos.dto.MarcaTotal;
import com.yaazfei.cadastrodeveiculos.model.Veiculo;


public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

	@Query("{'veiculo' : ?0 , 'marca' : ?1, 'ano' : ?2, 'vendido' : ?3}")
	List <Veiculo> buscaPor(String veiculo, String marca, Integer ano, Boolean vendido);
	
	Long countByVendidoTrue();
	
	List<Veiculo> findByCreatedGreaterThan (LocalDateTime date);
	
	
	@Aggregation(
			pipeline = {
			"{$group: {_id: { \n" +
			"marca: $marca} \n" +
			",count: {$sum: 1} \n" +
			"}} \n" +
			" {$project: {                      \n" +
			" _id: 0,                           \n" +
			" marca: {$toString: '$_id.marca'}, \n" +
			" total: {$toString: '$count'}      \n" +
			" }}                                \n"
			}
	)
	AggregationResults<MarcaTotal> buscarTotalPorMarca();

	@Aggregation(
			pipeline = {
					"{$group: {_id: { \n" +
							"ano: $ano} \n" +
							",count: {$sum: 1} \n" +
							"}} \n" +
							" {$project: {                      \n" +
							" _id: 0,                           \n" +
							" ano: {$toString: '$_id.ano'}, \n" +
							" total: {$toString: '$count'}      \n" +
							" }}                                \n"
			}
	)
	AggregationResults<AnoTotal> buscarTotalPorDecada();
	
	

}

