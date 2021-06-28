package com.yaazfei.cadastrodeveiculos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.yaazfei.cadastrodeveiculos.model.Veiculo;


public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

	@Query("{'veiculo' : ?0 , 'marca' : ?1, 'ano' : ?2, 'vendido' : ?3}")
	List <Veiculo> buscaPor(String veiculo, String marca, Integer ano, Boolean vendido);
	
	Long countByVendidoTrue();
	
	List<Veiculo> findByCreatedGreaterThan (LocalDateTime date);

}
